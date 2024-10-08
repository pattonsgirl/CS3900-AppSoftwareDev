# Product Requirements Document  
In-Class Project

## WorkOrder PRO

### Context

WorkOrder PRO is a software application that allows organizations to send technicians to service calls and organize their operations. The application has a straightforward UI requiring no training for the user to get started. Using WorkOrder PRO, the user can create and edit work orders, assign the work order to a technician, and update the work order status. The user will also be able to search for a specific work order in their overview of work orders. 

The current status of this application is ideation.

***

### Use Case(s)

“This is Jay Smith with Jay’s Plumbing Company. How can I help you”. The standard way Jay answers his phone, but these days he might as well change it to “This is Jay Smith with Jay’s Plumbing Company. I’m really sorry, what did I forget this time”? 

Jay has been a plumber since he started working 20 some years ago. After working for several companies Jay started his own company 5 years ago. The first year went great as Jay was the only employee and his large network got him lots of work. So much work he was able to hire 3 other plumbers in year 2. Since then Jay is spending more time organizing the work than doing plumbing work himself. This transition has been difficult for Jay and he does not enjoy it. When Jay hired his first employee he looked into software applications, but they had so many features he was overwhelmed. He decided to keep track of everything on paper because that was the simple solution. As his business keeps growing this is becoming a bigger challenge, to the point that things are getting missed daily. 

Every day Jay thinks to himself: “If there was only a simple software application, without all the bells and whistles, I could use to organize the Work Orders. One that will not take an MBA to understand and operate. All I need is an application that allows me to send my people to the right customer, keep track of the work they do, how much to charge, and the status of the work.

***

### Objectives

The mission of WorkOrder PRO is to “Provide organization that offer trades work to their customers with a simple yet effective way of organizing their work orders”. 

The target customers for the WorkOrder PRO application are smaller trades companies (0-5 employees) that are currently not using a Work order management system.  

The goals for the WorkOrder Pro application are: 
- 90% of users can set up their work orders, and assign technicians with without formal training 
- 20% reduction of time spent on managing work orders manually
- 50% reduction in errors compared to managing work order manually

***

### Assumptions

The following assumptions have been made while creating the Product Requirements Document: 
- We have all the knowledge and expertise to build this application. 
- We will have funding and company resources such as GIT, Docker, AWS, etc. are available to us 
- We will have sufficient time to complete the tasks within the required timeframes

***

### Requirements

- The user is able to create Work Orders. The following information is on a Work Order 
    - Status 
    - Date the work was ordered 
    - Customer 
    - Date the work is scheduled to be done 
    - Technician doing the work 
    - Date the work is completed 
- The user is able to add the following customers information to the Work Order:
    - First Name 
    - Last Name 
    - Address line 1 
    - Address line 2 
    - City 
    - State 
    - Zip code 
    - Phone Number 
- The user is able to add the work needing to be done to the Work Order:
    - The Product(s) or Service(s) 
    - Quantity 
    - Cost 
    - If the work is taxable 
    - Tax 
- The user is able to assign the Work Order to a technician:
    - Technician First Name 
    - Technician Last Name 
    - Technician Address 
- The user is able to update any information on an existing Work Order 
- The user is able to search/filter existing Work Orders on:
    - Date the work was ordered 
    - Date the work was done 
    - The assigned technician 
    - The customer 
    - The Product or Service 

Extra credit capabilities: 
- The user is able to delete an individual Work Order 

Honors capabilities:
- The user is able to delete all selected Work Orders

***

### Scope

The scope of this project includes: 
- Database creation using MariaDB 
- All frontend development, using Angular
- Backend development, connecting the frontend to the database using JAVA

Outside the scope of this project: 
- Any communication with technicians, customers, suppliers, etc. 
- Collecting or recording payments from clients 
- Documenting any compensation payments to technicians 
- Creating any financial documents such as profit/loss statements, balance sheets, income statements, etc.

***

### Performance

The following performance metrics:
- The application loads within 3 seconds 
- The load time to move from one page to another page is less than 1 second

***

### Open Questions

***


