import requests
import json

API_KEY = "5dfc00a457e4318b8034a24d10d3bc56"
WS_URL = "https://api.openweathermap.org/data/2.5/weather"

def fetch_weather(s):

    request_url = WS_URL + "?q={},US&units=imperial&APIKEY={}".format(s.replace(' ','%20'),API_KEY)
    response = requests.get(request_url)
    if response.status_code == 200:
        d = json.loads(response.text)
        print("The high temp of today in {} is {} degrees fahrenheit".format(s,d["main"]["temp_max"]))
        print("The Atmospheric pressure in {} is {} Hectopascals ".format(s, d["main"]["pressure"]))
    else:
        print("how should I know")
        print(response.status_code)


if __name__ == "__main__":
    s = input("From what city to do you need the current forecast?: ")
    fetch_weather(s)