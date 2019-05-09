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
        return str(self.name)


class Route:
    cities: object

    def __init__(self, city_list ):
        # assuming city_list is a list containing object of the City class
        self.cities = city_list

    def avg_temp(self):
        temp = 0
        for t in range(len(self.cities)):
            temp = self.cities[t].get_temperature(t)
        temp /= len(self.cities)
        return temp

    def __str__(self):
        return " ".join(str(city) for city in self.cities)
    #todo maybe use join to create a nice string contaning the route eg. city1 : city2 : ..

    def __len__(self):
        return len(self.cities)

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

def best_route():
    #find the best route of all possible routes
    best_route = Route(cities)
    while p:
        temp_route = []
        # test the current permutation
        r = p.pop()
        for i in range(len(cities)):
            #append the current permutation the temp_route
            temp_route.append(cities[r[i]])
        #create route object to test if it is the best possible route
        potential_best = Route(temp_route)
        if potential_best.avg_temp() < best_route.avg_temp():
            best_route = potential_best

    return best_route

if __name__ == "__main__":

    try:
        id_list = json.loads(open("cities.json").read())
    except IOError:
        print( "Could not read file:")

    cities = []
    for id in id_list:
        cities.append(fetch_weather(id))

    p = list(permutations(range(5)))
    best = best_route().cities
    best_path = Route(best)
    print(best_path)

    # loop to find the average for one specific route
