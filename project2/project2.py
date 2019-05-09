import requests
import json
from itertools import permutations

API_KEY = "5dfc00a457e4318b8034a24d10d3bc56"
WS_URL = "https://api.openweathermap.org/data/2.5/forecast"


class City:
    def __init__(self, name, temperatures):
        self.name = name
        self.temps = temperatures

    def get_temperature(self, day):
        return self.temps[day]

    def __str__(self):
        return self.name


class Route:
    def __init__(self, city_list ):
        # assuming city_list is a list containing object of the City class
        self.cities = city_list

    def avg_temp(self):
        temp = 0
        for t in range(len(self.cities)):
            temp += self.cities[t].get_temperature(t)
        temp /= len(self.cities)
        return temp

    def __str__(self):
        return self.name
    #todo maybe use join to create a nice string contaning the route eg. city1 : city2 : ..

def fetch_weather(id):
    # request parameter(s): Start with '?'
    # separate name and value with '='
    # multiple parameter name value pairs are separate with '&'
    query_string = "?id={}&units=imperial&APIKEY={}".format(id, API_KEY)
    request_url = WS_URL + query_string
    print("Request URL: ", request_url)
    response = requests.get(request_url)
    if response.status_code == 200:
        d = response.json()
        city_name = d["city"]['name']
        lst = d['list']
        tmp_list = []
        for i in range(len(lst) // 8):
            li = [x for x in range(len(lst)) if x // 8 == i]
            tmp_list.append(max([lst[j]["main"]["temp_max"] for j in li]))
        return City(city_name, tmp_list)
    else:
        print("How should I know?")
        return None


if __name__ == "__main__":

    try:
        id_list = json.loads(open("cities.json").read())
    except IOError:
        print( "Could not read file:")

    cities = []
    for id in id_list:
        cities.append(fetch_weather(id))
    avg_temp = 0
    p = list(permutations(id_list))
    print(p)
    for id_list in range(len(cities)):
        city = cities[i]
        print(city)
        avg_temp += city.get_temperature(i)
    avg_temp /= len(cities)
    print(avg_temp)

