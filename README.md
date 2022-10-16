# selenium-cucumber
Selenium vs Cucumber: Core Differences    
By Kristijan Pajtasev, Community Contributor - June 16, 2022


Testing is very important when it comes to software development. It not only helps you ensure that the code you develop is working correctly, but also that it did not break the existing code. If you are working on web applications, you probably have already heard of Selenium and Cucumber. Both are quite popular solutions. But what is their purpose? How do they fit together and which one to choose? 

This guide highlights the core differences between Selenium and Cucumber. 

Table of Contents
What is Selenium
Advantages of Using Selenium
Disadvantages of Using Selenium
What is Cucumber
Advantages of Using Cucumber
Disadvantages of using Cucumber 
Selenium vs Cucumber: Differences
When to use which?
What is Selenium
Selenium is an automation tool for testing web applications. Very clear, right? Or just a generic sentence that raises more questions than answers?  

Let us look at a scenario. 

You develop a web application. Once you are done, you want to test it. So you will open it in Chrome. Click the Menu icon, and click around to ensure that everything is working as intended. But not everyone uses Chrome, and now you need to repeat everything in Safari and Firefox and every other browser and device the user uses. This is quite cumbersome. The load keeps increasing as you get deeper into the browser matrix.

Any small change that you make to your application also has to be tested on all these browsers. Thus pushing any QA into the rabbit hole.

This is where Selenium comes to the rescue. 

With Selenium, all that you have to do is write tests. These tests automate the whole process for you. You can write tests for practically all the use cases like checking elements, functionality, behaviour, etc. Selenium executes these tests automatically and in all the browsers you want. 

Also Read: All you need to know about the Selenium Framework

Selenium supports all major programming languages like JavaScript, Python, Java, PHP, etc. And when it comes to supported browsers, Selenium runs all the tests through the browser-specific driver. That means running tests on the additional browser is just a matter of installing an additional driver.  

BrowserStack allows you to seamlessly execute Selenium tests on different browsers. You can test your web applications on 3000+ real devices and get accurate results.

Try Selenium Testing for Free

Advantages of Using Selenium
Automates testing across browsers
Open-source
Supports multiple tabs
Well documented
Can be written in any popular programming languages 
Disadvantages of Using Selenium
Requires browser-specific driver
Doesn’t have a built-in reporting tool
It has challenges with handling iframes 
The user needs to be familiar with some programming language
Read More: Limitations of Selenium

What is Cucumber
Cucumber is the tool for writing behaviour-driven tests. But first, what are behaviour-driven tests?

You may know how to write general tests. Usually, it is something like, you find an element selector, use it check its contents, and compare it with the expected value. With BDD tests, you describe behaviour. You write human-readable text describing the user requirements. This text results in tests being executed. This is where Cucumber comes into play. This tool enables you to convert that text into the testing code. For instance, if there are multiple unit tests, with Cucumber you can describe some expected user behaviour. These tests often define acceptance scenarios for features.

Read More: Introduction to Cucumber Testing Framework

When writing Cucumber tests, there are two parts you need to do –  Steps and features.

Steps: Steps are functions. These functions help you perform a testing action. That could be to load a web application, click some element, enter text into the input field, or anything that the user might be doing. These functions are written in the programming language you chose and also contain text for which they are triggered.
Features: Features contain scenarios, which are your text. They describe behaviour starting with keywords and based on those sentences, Cucumber maps them to the right step to be executed.
It might be a bit simpler by using the example. 

Scenario: The menu opens when the icon is clicked
Given you load the landing page
When you click the menu item
Then a menu will be visible

The above example has four lines. 

1st line: This is the scenario line and just defines that it is the start of the test scenario. Something like a short description of what is happening in this test.
2nd line: This first used step, and from the description of it, we can assume that the step code will open the landing page of the application in the browser.
3rd line: Once the page is loaded, this step will click on the menu item. The logic behind would have a selector for the menu icon on the page and trigger a click even on it.
4th line: This last line triggers step checking if the menu is visible. The way it is written above is quite straightforward and very understandable. However, in the step definition again, there would be some selector for the menu element. Then the code would try to fetch that element and see if it exists and if it is visible.
As you can see, tests written this way are easy to comprehend for both developers and business users. You might think, why would we want non-technical people to understand code? And that is a good question. But it is not about them understanding the code, it is about getting both sides on the same conversation. Behavior-driven tests directly mirror requirements and could be used in your ticket to define them.

Advantages of Using Cucumber
It is human-readable, which means business people can understand it
Steps can be written in any programming language
Because it uses human-readable text, can be used for describing user requirements
Disadvantages of using Cucumber 
It requires user involvement to describe scenarios right
Requires maintenance of both steps and scenarios
Selenium vs Cucumber: Differences
Here are a few differences between Selenium and Cucumber:

Selenium is a test automation framework whereas Cucumber is a behavioural testing tool.
Selenium is written in programming languages like Java, .Net, etc. whereas Cucumber is written both in programming language as well as plain text.
Selenium supports conditional statements but Cucumber does not.
Test Scripts are written based on requirements in Selenium but with Cucumber, you start with scenarios first.
Selenium scripts are hard to develop whereas Cucumber was easier to develop.
Identifying syntax errors is pretty easy while you are developing the script, whereas you cannot find errors in Cucumber.
Both Selenium supports Perl, Python, Java, PHP, .Net, etc.
Here is a tabular version of the differences between Cucumber and Selenium 

Criteria	Selenium	Cucumber
Is it a framework	Yes	No
Automation for	Automation tool for E2E tests	Automation tool for BDD tests
Programming Knowledge	Requires programming knowledge to understand	Easier to read as it is written in both programming language as well as plain readable format.
Setup	Difficult to install when compared to Cucumber	Easy to install
Type of Testing	Selenium is used for functional and performance testing	Cucumber is used for story testing
Programming Language	Mostly written in Java	Mostly written in Ruby
Use case	Focused on web applications	Could be used for testing any type of software
Test Execution	Script execution is quite fast	Test execution is slow
Reliability 	Highly reliable	Less reliable when compared to Selenium
Supporting Language	Python, Ruby, Java, .Net	Ruby, Scala, Groovy, Java
When to use which?
From the description of what Selenium and Cucumber are it might be already clear. Both are used in testing, but each has a slightly different role. Selenium automates tests, and Cucumber helps us make them more readable. You could think of it as driving a car or getting a taxi. Both will get you to your location. You can use Cucumber without Selenium, just like you can use Selenium without Cucumber. But by using them together, you get a combination where you write clear and understandable tests to everyone with Selenium running them on all required browsers. That said, you can use Selenium and Cucumber in tandem with each other. 

Most organizations, today use Cucumber along with Selenium as it makes it easier to read and understand the flow of applications among the members from different teams. 

Cloud testing products like BrowserStack support Selenium testing with Cucumber.

What Is Cucumber? 
Cucumber lets you write test scenarios using plain language. 

It is a tool for behavior-driven development (BDD). BDD is a software development process that encourages cross-functional collaboration, in part, through use of a plain-English scripting language called “gherkin” that anyone, technical or not, can read, write, and understand. 

Originally written in the Ruby programming language, Cucumber now supports a variety of different programming languages, including Java and JavaScript. The Cucumber framework is commonly used for acceptance tests. 

Preferred by Business Testers 
If you have business testers on the team, they would likely prefer to use Cucumber — or another BDD framework, like Quantum — since can be used without coding knowledge (which Selenium requires).  

Cucumber uses a “given-when-then” framework for writing a test. After defining the feature and scenario under test, you provide the context (given), user action (when), and the expected outcome (then). 

Cucumber BDD Example 
Scenario: Login
Given: User navigates to perfecto.io 
When: User logs in using Username as “tester” and Password “extraordinaire” 
Then:  Login should be successful 

Is BDD Worth It?
Cucumber’s behavior-driven development (BDD) library for Java Script is downloaded over half a million times every month. But is BDD worth it? Find out by watching the webinar below.

Using Cucumber Within A Selenium Framework
Some organizations implement Cucumber within a Selenium framework to allow for reliable test automation that emphasizes plain language. By doing so, they can: 

Develop a shared understanding of how software should perform. 
Improve collaboration between testers, coders, and decision-makers. 
Automate web testing across browsers at scale.  
Keep in mind, however, that in some cases the business side of the organization may not have input or opinions as to how the application behaves. It may also be true, depending on the size of your QA team or who is doing the automation work, that an extra layer of tooling to make tests more humanly readable (as with Cucumber) will not add value. In both cases, using Cucumber at the test creation phase may not be necessary.  

Bottom Line 
While Selenium and Cucumber have some overlap — both are open-source and used for functional testing — their similarities end there. Selenium is used to automate web browsers, whereas Cucumber is used for behavior-driven development. Finally, because Selenium requires coding knowledge, it is often picked by SDETs and developers. Cucumber is a go-to for business testers. 


