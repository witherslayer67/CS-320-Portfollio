# CS-320-Portfollio

To make sure my code is actually functional and secure, I like to write a bunch of unit tests using JUnit to check all the annoying edge cases, like when someone puts in a null value or types way too many characters. When I'm trying to figure out what a user or client actually needs, I look closely at the rules they give us, like making sure a contact phone number is exactly 10 digits or that an appointment date is set in the future, and turn those straight into requirements for my code.

When I'm designing software from scratch, my go-to approach is to break everything down into clean, separate pieces so it doesn't turn into a total mess. For example, I separate the core data objects from the service classes that handle storage and logic, like how `Contact` and `ContactService` work together, which makes debugging way easier and keeps my project super organized.
