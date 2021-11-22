# Marvel Character API

Project created for the Growin Coding Challenge.

To run the API correctly on your machine, follow the steps below!

## Summary

1. [Installations](#wrench-installations)
1. [Startups](#rocket-startups)
1. [How it works](#computer-how-it-works)
1. [Improvements](#chart_with_upwards_trend-improvements)
1. [Author](#-author)

## :wrench: Installations

Please install the following tools on your machine:

* [Git](https://git-scm.com/downloads)
* [Java](https://www.java.com/pt-BR/download/)
* [Eclipse IDE](https://www.eclipse.org/downloads/)

## :rocket: Startups

Tópico para inicializar a API.

### Downloading Project

1. Open the following link: https://github.com/pitdelling/marvelcharacterapi.git
1. Click "Code" and then "Download ZIP"
![image](https://user-images.githubusercontent.com/16709062/142873271-442aaeb9-36dd-41ce-892a-6f26d1abaaf6.png)
1. Unzip the downloaded project;
1. Open the Eclipse IDE;
1. Right click on the "Package Explorer" tab;
1. Click on the "Import" option;
1. Type "maven" in the field "Select an import wizard", and choose the option "Existing Maven Projects";
![image](https://user-images.githubusercontent.com/16709062/142873661-a032be79-ce6d-40a4-a119-2f05078be1b7.png)
1. Navigate to the unzipped folder, and select it, after that, just click "Finish";
![image](https://user-images.githubusercontent.com/16709062/142873905-a4493860-ee8b-47eb-bdf2-2b68f6862ff9.png)
1. Press `Ctrl+Shift+R`, type "MarvelcharacterapiApplication", select the java file, and click in "Open";
![image](https://user-images.githubusercontent.com/16709062/142874251-5146826f-78e0-4565-a840-54f4ae701c40.png)
1. Right-click on the file, and choose "Run As" > "Java Application";
1. When the console shows "Started MarvelcharacterapiApplication in...", it means the API is running and can be tested;
![image](https://user-images.githubusercontent.com/16709062/142874556-68848fda-ab1c-4202-ab55-cf1e46430397.png)

## :computer: How it works

You can choose how you want to test, there are at least 2 easy ways and one a little more difficult.

The 2 easiest are:

* Using the Swagger (http://localhost:8080/swagger-ui.html), which is very intuitive;
* Or by the browser itself, placing the link you want to access in the URL:
![image](https://user-images.githubusercontent.com/16709062/142875385-3d6c27a9-6b4b-4e32-9648-2959e34d5593.png)

The way I commented, which is a little more difficult, would be by Postman. But I didn't use it for testing, so I don't have a print to show how it works. However, it is also very intuitive if you want to test for it.

## :chart_with_upwards_trend: Improvements

There are several points of improvement for this project. However, there are two very important ones that I couldn't solve:

1. I couldn't find a free unlimited library or API for text translation. So I used RapidAPI, which was handy, but only allows for a few translations before it stops translating. In this case, the print of the percentage of use already enjoyed follows. If you stop translating, it's because you've reached your maximum.
![image](https://user-images.githubusercontent.com/16709062/142876938-29386fa5-fc70-4dce-8a76-f418dc9a2e13.png)
1. Second, I couldn't get the two API keys I'm using stored elsewhere. I tried to solve this problem. But I didn't find a good quick fix that I could do in time.

## 👤 Author

![Philip - Professional Photo-small](https://user-images.githubusercontent.com/16709062/105726472-e3228700-5f08-11eb-8449-42683562439b.jpg)

Application created by [Philip Ibbotson T. Delling](https://github.com/PhilipAngular). Contact me 👋:

[![Linkedin Badge](https://img.shields.io/badge/-Philip&nbsp;Ibbotson&nbsp;T.&nbsp;Delling-blue?style=flat&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/philip-delling/)](https://www.linkedin.com/in/philip-delling/)
[![Gmail Badge](https://img.shields.io/badge/-philip.i.t.delling@gmail.com-c14438?style=flat&logo=Gmail&logoColor=white&link=mailto:philip.i.t.delling@gmail.com)](mailto:philip.i.t.delling@gmail.com)
