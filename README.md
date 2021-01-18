# Rental-Web-App
# Abstract

The demand for electrical devices keeps growing every year as more people rely on these devices in order to accomplish their everyday goals. Whether it's a camera to capture beautiful moments or a television to watch the latest movies. Almost everyone uses electrical devices for various reasons. Although there is a lot of demand for a lot of these devices, a lot of people do not end up buying them as they are either too expensive or the people mind not find it worth paying so much for something that they may not use as often. In certain cases, people do end up buying these devices which they end up not using as much as they expected and then regret purchasing it. 
To solve the mentioned issue, renting comes into play. There are rental stores that rent out electronics to people but they are scarce and difficult to find and even if one is found they end up lacking a variety of devices so people hardly find exactly what they are looking for.
My solution therefore, is an online peer to peer rental marketplace applications where people living around each other  can gather to facilitate the exchange of electrical device for short periods of time for an agreed price.




# Introduction

This report shows what work I have done in the past academic year on my peer to peer electronic device rental web-app. Giving all the details on the ideas, steps, implementations and processes that were involved in creating the final project.

## Aims

The aim of this project used to be to create a web application where users are able to rent cars and electronic devices ranging from a single day to as many days as they would like from other users who want to rent out their cars and electronic devices(such as televisions, consoles, cameras etc). Now, I have decided to drop car rentals from the aim and focus only on electric device rentals because it will allow me focus more on building the web app to specifically suit electric device rentals.This will allow users be able to use these devices for short periods of times at good prices without needing to spend so much on buying the device and also provides a less rigid, user friendly, cheaper and faster alternative to traditional rental companies.

# Objectives

Research to find out what kind of electronics people will like to rent and also to find out what electronics people will be ok renting out to others. Also, research has to be done to understand the pricing of the rentals. This will be done by looking at the cost of renting in other renting markets and conducting surveys asking people how much they will be willing to pay to rent particular items.

To enable users to search for items using different filters such as price per day, brand, location and of course the particular dates they want to rent out the item. After entering the required search fields, the items that best fit their description will be shown and they will be able to click on any of the choices for more information on the product. They will be able to see pictures of the item, the cost, the renter, available dates and other information regarding the item. If the user decides to rent the product, he then books it for the days he wants it and he can either choose to go and pick up the item or have it delivered to him at an added cost. At the end of the renting period the users payment will be made and the item will need to be returned to the owner.

To enable users to be able to rent out their devices, when they list an item they will given a daily estimate amount to use to rent out their item which will depend on the value of their item. They can decide to use this or go ahead with their own daily rent price. They will also have a calendar so they can mark the days they are available to rent out their item. When someone books their item they will be notified and have a choice of whether to accept the booking or decline it.

To enable users to be able to view their bookings and also be able to either edit and delete it. They will also be able to see all their history of what they’ve rented incase they ever want to rent the same thing again.

To provide a rating system for both the people renting and the owners of the devices being rented. After a renting period is over the renter will be able to rate the owner based on different things such as device performance and owner service. And the owner will also rate the renter based on how well the item was managed while being rented etc.

Setup a database to store user info, rental information, bookings and other relevant data

Find a server to host the system which will publish the web application.

Use spring mvc to build a web application to provide a user interface for its operations.

Create an algorithm to show the best options when users search for products to rent.

Learn and Implement j unit tests and integration tests to make sure software is quality and detect errors and faults.

Integrate payment into the web-app to enable users make and receive payments.


# Background Research

I have carried out various forms of research from news articles and various websites to find out how I can make my project is as good quality and user friendly as possible and also offer a service to people that will solve a problem they have.

From having people interviewed and sending out surveys, I have found out that many people have electronics they have needed at different times to serve a particular purpose but because of issues like cost and storage, they ended up not getting it. I also found out that people have electronic devices and appliances that they have but hardly or never use for example, a second phone, televisions, speakers and projectors. I further asked if they would have rented the electronic device/appliance if they were able to rent it at an affordable price for any number of days and majority of the people asked  agreed that yes they would have gotten it.

From [1] I have seen that technology has reduced transaction costs, making sharing assets cheaper and easier than ever—and therefore possible on a much larger scale. The big change is the availability of more data about people and things, which allows physical assets to be disaggregated and consumed as services. This allows people to be able to rent things from each other in a faster and seamless process. Which saves cost of having to buy expensive products, allows the renters to make good use of their goods that they don’t use as much while making money from it.

Peer-to-peer exchange is growing rapidly. In 2015, Airbnb indicated that they had over one million hosts on their site, and over the summer of 2015, indicated their hosts were accommodating over a million guests per night, making them comparable in inventory and transaction volume to the world’s largest hotel brands.[4] 

There are many tech companies that are being made using this system for example, Turo which specialises in car peer-to-peer rentals, this company was launched in 2010 in Boston. Today they have over 4 million users and is used in various states in America, Canada and more recently it has started operations in the UK.[5] Also another startup peer-to-peer rental marketplace for almost anything is Fat Lama which launched in 2016, this company which was launched in the UK keeps growing and recently raised  $10 million in Series A funding. They have already started operations in New York earlier this year and got 6,000 items listed in the first couple of months there.[3]

A lot of people using this peer-to-peer exchange system to rent out their goods have made quite a bit of money on the side. A photographer Antonio Salvani makes up to $4000 a month renting out camera equipment and from that he has been able to buy his mother a £30,000 flat in Macedonia.[2]So this proves that users of these platforms benefit as well.

All these shows how large of a market there is for peer to peer renting around the world which has led to the creation of various startup companies trying to tap into the fast growing market and why I’ve decided to make my project based on this.


# Business development

## Problem:
A lot of electronics are expensive and unaffordable for a huge percentage of people who would like to use them and because of these high prices they cannot purchase to make use of these electronics. In a number of situations certain people are able to get enough money to purchase these electronics but then these people end up not using these electronics as much as they had planned to and end up not getting back enough from the amount of money they had spent purchasing it. Another problem is that people may need a certain electronic for one time usage and it would not be a smart move to spend so much on purchasing it only to end up using it a couple of times. A number of electronic rental stores might exist but the range of products they will have up for rent are usually not that much. Also, the process of getting to rent from these stores can be tedious and they tend to be expensive.

## Solution:
A web-app that brings people who own electronics that they do not use frequently and would like to make money by renting them out together with people who are willing to pay to rent an electronic for a particular time period. The users will then able to get the electronics they want from other users conveniently and at reasonable prices and they will have a range of products to choose from.

## Unique Value Proposition: 
Provide affordable peer-to-peer electronic rentals.

This means that I am providing users the option of renting electronics that they want to use for a certain period of time and could be quite expensive if they were to buy it. Also this allows people to not have to buy electronics that they do not regularly use. Instead of using so much money to buy the electronic and end up keeping it away most of the time, they could just rent it for the amount of time they need it for and return it. This prevents wastefulness of electronics and money. This is also a way for people to make money of their electronics that they don’t use all the time by renting it out to people who would like to make use of it for a limited period of time. These electronics can range from cameras and camera equipment to drones to DJ equipment and so on and so forth so everybody will find something they are looking for as long as it is an electronic.


## The Customers:
The potential group of customers is extremely large as it involves any person that uses electronics and in this day and age majority of people make use of this technology. This means that this web-app is usable by anyone worldwide. It will connect people based on their locations as it would make sense to be able to rent an electronic from someone that is close by. Therefore you will only be able to rent and rent out to people currently in the same city as you. For this project in the meantime I will be focusing on Leicester as it is a good city to test the web-app in.
I have interviewed various friends and family members which includes people of various ages and locations. Most of the people I interviewed were university students. I asked them questions such as:
What electronic would you rent rather than buy?
What percentage of the total cost of an electronic will you pay for per day?
Would you rent out any electronics you don’t use often?
For how many days would you see yourself renting an electronic for?

For the first question,I got various answers such as cameras, drones, video game consoles, televisions etc. For the second I got about 1 percent of the total cost of the product on average. So let’s say an iPhone XS that costs about £1000 was rented out the average price a person would want to pay per day of renting it is £10 per day. And for the third question most people around my age group or below 30 said they would be open to renting out the electronics they don’t use as much. For the last question answers ranged from 1 day to about 2 weeks but the average was about 3-5 days.

## The Market:
A peer to peer marketplace platform is an online business model where buyers and sellers exchange products and services. The market my project is involved in is an online peer to peer market which over the past two decade has rapidly become more popular with the likes of eBay, amazon and Alibaba leading the way. According to angelist there are over  1,239 marketplace platforms with the average valuation of these platforms being $3.5 million and this market will be worth $355 billion by 2025 as per PricewaterhouseCoopers. Among these marketplace platforms, a number of them are involved in rental of goods. For example-

airbnb - www.airbnb.co.uk
This allows users rent out their houses or rooms in their houses to other users who are looking for temporary accommodation as an alternative to hotels.

turo - www.turo.com
This allows users to rent out their cars to other users who are looking for a car to use for a period of time.

fat llama - www.fatllama.com
This allows users to rent out anything they own out to other users for an amount of time.

Looking at competition in the market there are various competitors some which are direct competition and others which are indirect competition. For direct competition, Fat Llama is the only online software company I have found that can be classified as direct competition. Apart from them, physical rental stores such as rentacenter and other smaller stores are also direct competition.

For indirect competition, online marketplaces such as Amazon and eBay where users can just buy the electronics instead of renting it are seen as my competitors. Also, physical electronic stores such as Cex, Currys, Argos, Apple and Samsung stores are also under indirect competition.


## Revenue Model:
When users rent out their electronics, there will be a cost per day for it and at the end of the rent period when the renter pays for the item 15% of the payment will be taken out and remain with me while the remaining 85% will go to the piercing renting out their electronics. For example lets say someone lists their camera for £20 a day and someone rents it out for 5 days, that will be a total cost of £100 the person renting it has to pay. £15 pounds from it will belong to me while the rest of the money which is £85 will go to the owner of the electronic item.
