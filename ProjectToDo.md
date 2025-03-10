## What is the project?
A console-based application where users can: 
- Add tasks with a description and due date.
- View all tasks in a sorted order.
- Mark tasks as complete.
- Save tasks to a file and load them when the program starts

## To Do List
1. Set up Maven:
- JUnit for testing
- Jackson for handling JSON

2. Design your package structure: 
- Model: Create a "Task" class to represent individual tasks.
- Service: Manage the list of tasks (e.g. adding, sorting, marking as complete).
- UI: Handle the console input and output.

3. Implement features
- Add tasks with properties such as title, description, due date, completion status.
- List tasks and sort them based on the due date. 
- Mark tasks as complete

4. Persist data: 
- Save the task list to a JSON whenever tasks are updated. 
- Load the tasks back into memory when the application starts.

5. Test your application:
- Use JUnit to write test cases for the Task class and other functionality.

6. Build and run: 
- Use Maven goals like "mvn compile", "mvn test", and "mvn package" to compile, test, and create a jar file for your application.