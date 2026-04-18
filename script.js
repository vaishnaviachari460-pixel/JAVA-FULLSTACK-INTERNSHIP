<!-- // Q1: Basic Calculation
let a = 10;
let b = 5;

console.log("Addition:", a + b);
console.log("Subtraction:", a - b);
console.log("Multiplication:", a * b);
console.log("Division:", a / b);


// Q2: Comparison Check
console.log("a > b:", a > b);
console.log("a == b:", a == b);
console.log("a != b:", a != b);


// Q3: Logical Operator
let age = 20;
let hasID = true;

if (age >= 18 && hasID) {
    console.log("Allowed");
} else {
    console.log("Not Allowed");
}



// Q4: Even or Odd
let num = 7;

if (num % 2 === 0) {
    console.log("Even");
} else {
    console.log("Odd");
}


// Q5: Grade System
let marks = 85;

if (marks >= 90) {
    console.log("Grade: A");
} else if (marks >= 70) {
    console.log("Grade: B");
} else if (marks >= 50) {
    console.log("Grade: C");
} else {
    console.log("Fail");
}


// Q6: Print Numbers (1 to 10)
for (let i = 1; i <= 10; i++) {
    console.log(i);
}


// Q7: Sum of Numbers (1 to 5)
let sum = 0;

for (let i = 1; i <= 5; i++) {
    sum += i;
}

console.log("Sum:", sum); // 15


// Q8: Multiplication Table of 5
for (let i = 1; i <= 10; i++) {
    console.log("5 x " + i + " = " + (5 * i));
}


// Q9: Largest Number
let x = 10;
let y = 20;
let z = 15;

let largest;

if (x >= y && x >= z) {
    largest = x;
} else if (y >= x && y >= z) {
    largest = y;
} else {
    largest = z;
}

console.log("Largest Number:", largest);


// Q10: FizzBuzz
for (let i = 1; i <= 20; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
        console.log("FizzBuzz");
    } else if (i % 3 === 0) {
        console.log("Fizz");
    } else if (i % 5 === 0) {
        console.log("Buzz");
    } else {
        console.log(i);
    }
}



// Q11: Login Check
let username = "admin";
let password = "1234";

if (username === "admin" && password === "1234") {
    console.log("Login Success");
} else {
    console.log("Invalid Credentials");
}



// Q12: Count Even Numbers (1 to 20)
let count = 0;

for (let i = 1; i <= 20; i++) {
    if (i % 2 === 0) {
        count++;
    }
}
console.log("Even numbers count:", count);


//
function Sum(X,Y){
    S=X+Y;
    return S;
}
let val=Sum(3,4);
console.log(val);


 -->

 
