1:
Model View Controller Exercise 1
We are excited to introduce the new campus management system TUMOffline, however the implementation is not ready yet. Implement the last steps of the course management. In the end, we want a system that is capable of adding new courses and listing existing courses. The views that display a single course and display all courses should always be synchronized. To do so, the system should follow the general approach of the Model View Controller (MVC) architectural style.

Clone the project and import it to your IDE as Gradle Project.

Part 1: Model
First, we need to implement Model components.

 Make sure that all observers get notified 1 of 1 tests passing
Implement the method notifyObservers() in the class Observable. This method should update all observers.

Part 2: Controller
The next step is to implement the Controller. Before we can do this, we have to implement the addCourse method in CourseListView since the Controller depends on it.

 Implement addCourse in CourseListView 3 of 3 tests passing
Implement the method addCourse() to add a course to the list. Make sure that you don't get any duplicates and that the list view observes the added course.

 Implement saveCourse in Controller 1 of 1 tests passing
Make sure that the course gets added to the list view and all observers get notified about this.

 Implement selectCourse in Controller 2 of 2 tests passing
Initialize the given CourseDetailView in selectCourse and display the CourseDetailView.
Hint: You can display a view by calling the method show().

Part 3: View
The final part is to implement the rest of the View components.

 Finalize constructor implementation in CourseDetailView and CourseListView 2 of 2 tests passing
Make sure that all parameters get set correctly and the view is an observer of each course.

 Implement selectCourse in CourseListView 1 of 1 tests passing
Send the controller the information to open up a new detail view.

 Implement createCourse in CourseListView 1 of 1 tests passing
Inform the controller about the creation process of a new course in which the user will provide the data. Hint: Creating here is equivalent to selecting a course.

 Implement save in CourseDetailView 1 of 1 tests passing
Implement the method save() and make sure that the course gets updated with the information entered by the user and then the course gets saved with the controller.
Hint: Use the attributes idTextField and nameTextField to retrieve the data.

 Implement update in CourseDetailView 1 of 1 tests passing
Implement the update() method and make sure that the TextFields mentioned above are updated as well as the title of the window showing the CourseDetailView (you can use the method toString() of Course for that). Hint: JavaFX provides a method setTitle(String).

To try out your application locally, just run the main-method in UniversityMain.

The following simplified UML model shows the relationships between the classes.
<img width="748" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/5370c857-0b7e-41a6-b671-5b512803805c">
2:
Chip Factory
In this exercise, you will implement a chip factory using Model View Controller (MVC). You will simulate a computer chip factory that produces transistors and further assembles them to actual computer chips (CPUs or GPUs).

Note:

Use your local IDE since this exercise relies on graphical elements.
In this exercise, there is existing code for the views. Your task is to apply the MVC pattern.
UML diagram
The following UML model shows an overview of all classes (model, view and controller) and their relationships. The distribution into model, view and controller is shown in several smaller diagrams after the tasks of the exercise.
<img width="860" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/4795849e-c3ab-471d-b3e7-fdfd6b4b0b43">
Part 1: Model
First, you need to create the model of the factory's machines.

The factory has two types of machines - one transistor machine, which can produce the transistors, and an assembly machine, which assembles them to actual computer chips. Also, there is one parent class - just called Machine - which represents similarities between them.

You have the following tasks:

 Set up the Machine 6 of 6 tests passing
First, add observers, a list of observers to the class Machine.
Then, implement the methods addObserver(Observer), removeObserver(Observer), which add resp. delete observers from the list.
Additionally, you have to implement the method notifyObservers(), which should call the method update(Machine) for each observer in the list.
Last but not least, make sure that all setters call notifyObserver(), so the views get to know the updates.

 Link the machines 2 of 2 tests passing
Remember what the setters of machines should do additionally and adjust them accordingly for TransistorMachine and AssemblyMachine.
Hint: Have a look again at the instructions regarding the Machine class.


Part 2: Controllers
In this part, you will implement the controllers. There are two main types of controllers - terminals and sensors. Sensors simulate input from machine sensors that measure the machine's current voltage or temperature. They can immediatly update the machine and do so in regular intervals. Terminals control user input received from the views. They check if the input for the respective machine is applicable and update it in such a case - e.g. they check if the transistor size or the target temperature fulfill the requirements wrt. min- and max- values.

You have the following tasks:

2.a) Sensors
 Link the sensors and the machine 2 of 2 tests passing
Add a machine attribute to the Sensor classes. Then modify the constructor accordingly.

 Update the value generation 2 of 2 tests passing
Use the machine's targetVoltage to calculate a new value in the VoltSensor class.
Use the machine's targetTemperature to calculate a new value in the TemperatureSensor class.
After creating the new (simulated) values, we have to update the machine's currentValues accordingly in both classes.
2.b) Terminals
 Adjust the Assembly Terminal 12 of 12 tests passing
Add the necessary functions for using the terminal: Implement setTargetTemperature(targetTemperature), setTargetVoltage(targetVoltage) and setSpaceBetweenTrans(space).

 Adjust the Transistor Terminal 12 of 12 tests passing
Add the necessary functions for using the terminal: Implement setTargetTemperature(targetTemperature), setTargetVoltage(targetVoltage) and setTransistorSize(transistorSize).

 Adjust the Machine Terminal 8 of 8 tests passing
Add the necessary functions for using the terminal: Implement setTargetTemperature(targetTemperature) and setTargetVoltage(targetVoltage).
Hint: Use the machine attribute of the class and its functions and values for these tasks.

Part 3: View
In this last part, you will configure different views for the machines. The machine room view displays the general machine attributes temperature and voltage and accepts user input for the target values of these attributes. The control room views mainly display machine specific attributes (e.g. transistorSize or chipType) and accept user input for them. Therefore, these control room views have to be implemented for each machine type (TransistorControlRoomView and AssemblyControlRoomView).

You have the following tasks:

 Update the transistor control room view 2 of 2 tests passing
In the class TransistorControlRoomView, modify the constructor, so that it adds itself as an observer to the passed machine. (make sure, that you don't add the same view multiple times as an observer)
Afterwards, you need to adapt the update(Machine) method. It should update the machine specific values in the view. There are some hints in the ToDo-statement that will help you with the actual implementation.

 Update the assembly control room view 2 of 2 tests passing
In the class AssemblyControlRoomView, modify the constructor, so that it adds itself as an observer to the passed machine. (make sure, that you don't add the same view multiple times as an observer)
After that, you need to adapt the update(Machine) method. It should update the machine specific values in the view. There are some hints in the ToDo-statement that will help you with the actual implementation.

 Update the machine room view 2 of 2 tests passing
In the class MachineRoomView, modify the constructor, so that it adds itself as an observer to the passed machine.
Then, you need to adapt the update(Machine) method. It should update the machine specific values in the view. There are some hints in the ToDo-statement that will help you with the actual implementation.
Finally, the factory should be working :)
The following UML diagrams show the partitioning in model, view and controller of the different views of the chip factory.

1. Machine Room View
   <img width="567" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/51112b74-8843-40ab-9a09-15d074416245">
Graphical user interface
<img width="381" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/afe4843b-1c07-4259-9d8e-dbc9492986ed">
2. Transistor Machine View
   <img width="467" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/a602e2c6-932d-4974-bbbd-89ee1b398722">
Graphical user interface
<img width="394" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/48a04625-12a9-4744-83e4-72a486a2c6a0">
3. Assembly Machine View
   <img width="567" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/b114a0fd-b218-45ea-98e6-8c310b02b400">
Graphical user interface
<img width="359" alt="image" src="https://github.com/tstren1223/TUM_SW4/assets/64294878/fc43ce18-0a87-4aee-ab87-12bf4a2a7d80">



# TUM_SW4
