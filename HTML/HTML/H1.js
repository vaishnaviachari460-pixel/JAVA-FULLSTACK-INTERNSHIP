
//INHERITANCE

class Person {
    constructor(name) {
        this.name = name;
    }
}

class Student extends Person {
    constructor(name, marks) {
        super(name); // calling parent constructor
        this.marks = marks;
    }

    showDetails() {
        console.log(`Name: ${this.name}, Marks: ${this.marks}`);
    }
}

// Usage
let s1 = new Student("John", 90);
s1.showDetails();




//METHOD OVERRIDING

class Animal {
    eat() {
        console.log("Animal eats food");
    }
}

class Dog extends Animal {
    eat() {
        super.eat(); // calling parent method
        console.log("Dog eats bones");
    }
}

// Usage
let d1 = new Dog();
d1.eat();



//ENCAPSULATION
class User {
    #password;

    setPassword(pass) {
        if (pass.length < 6) {
            console.log("Password too short");
        } else {
            this.#password = pass;
        }
    }

    getPassword() {
        return this.#password;
    }
}

// Usage
let u1 = new User();
u1.setPassword("123");      // invalid
u1.setPassword("abcdef");   // valid

console.log(u1.getPassword());



//ABSTRACTION

class Laptop {
    #bootSystem() {
        console.log("Booting system...");
    }

    start() {
        this.#bootSystem(); // calling private method
        console.log("Laptop started");
    }
}

// Usage
let lap = new Laptop();
lap.start();