# citas-api-java

- API REST developed using some CRUD functions.

## Functionality and Data Model

### Patients
* It's possible to create a new patient.
* It's possible to find a specific patient by it's cedula.
* It's possible to get all patients that are registered in the database.
* It's possible to delete a patient by it's id.
* It's not possible to create a user which cedula is already existing in the database.

 ### Doctors
* It's **only** possible to create a new doctor per speciality due to the nature of the system. You cannot create more than one doctor per speciality.
* It's not possible to create a new doctor which cedula is already existing in the database.
* It's possible to find a specific doctor by it's cedula.
* It's possible to get all doctors that are registered in the database.

### Appointments
* You can **only** create a new appointment if the user's already registered. Otherwise you won't be able to do so.
* You can create appointments for an user with different doctors on the same day.
* You can create an appointment for an user with the same doctor in different days.
* You can create different appointments for an user in different days.
* You can get a specific appointment with it's ID
* You can get all the appointments that users may have made.
* You cannot create a new appointment for an user that already has an appointment with the same doctor on the same day.
* You cannot create a new appointment if the doctor for that speciality isn't registered.

### YouTube video testing the app: 
https://youtu.be/VCgQxcgASfg


## Endpoints
  * http://localhost:8080/patients
  * http://localhost:8080/patients/cedula/{cedula}
  * http://localhost:8080/doctors
  * http://localhost:8080/doctors/cedula/{cedula}
  * http://localhost:8080/appointments
  * http://localhost:8080/appointments/{id}

## Techstack

* Java 17+
* Maven
* Springboot
* MongoDB (local)

## Installation

1. Clone this repository.

```shell
git clone https://github.com/Blisse1/citas-api-java
cd citas-api-java
```

2. Run the project

3. Go to "sets" folder and start testing the app with the pre-defined examples.

4. Test it on Postman.



## Extra info
* Developer: Andrés Morales
* Universidad Distrital & Atenea: Intermediate Backend Bootcamp


