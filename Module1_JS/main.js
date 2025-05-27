// main.js — Full Implementation of All 14 Tasks

// Task 1: JS Basics & Setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("Page fully loaded");

// Task 2: Data Types, Operators
const sampleEventName = "Community Music Fest";
const sampleEventDate = "2025-06-10";
let availableSeats = 50;
console.log(`Event: ${sampleEventName} | Date: ${sampleEventDate} | Seats: ${availableSeats}`);

// Task 3: Conditionals, Loops, Error Handling
const events = [
  { name: "Book Fair", date: "2025-06-20", seats: 10, category: "education" },
  { name: "Music Festival", date: "2025-06-05", seats: 0, category: "music" },
  { name: "Charity Run", date: "2024-12-01", seats: 5, category: "charity" },
  { name: "Food Fair", date: "2025-07-15", seats: 20, category: "food" },
  { name: "Art Workshop", date: "2025-06-25", seats: 8, category: "workshop" },
  { name: "Tree Planting", date: "2025-06-28", seats: 15, category: "environment" },
];

function displayValidEvents() {
  const now = new Date();
  events.forEach(event => {
    const eventDate = new Date(event.date);
    if (eventDate >= now && event.seats > 0) {
      console.log(`Upcoming: ${event.name} on ${event.date} (${event.seats} seats)`);
    }
  });
}
displayValidEvents();

function registerToEvent(eventName) {
  try {
    const event = events.find(e => e.name === eventName);
    if (!event || event.seats === 0) throw new Error("Event not available");
    event.seats--;
    console.log(`Registered to ${eventName}, Seats left: ${event.seats}`);
  } catch (e) {
    console.error("Registration failed:", e.message);
  }
}

// Task 4: Functions, Scope, Closures, Higher-Order
function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

function registerUser(name, email, eventName) {
  registerToEvent(eventName);
  return `${name} registered for ${eventName}`;
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category === category);
}

function registrationTracker(category) {
  let count = 0;
  return function () {
    count++;
    console.log(`Total registrations for ${category}: ${count}`);
  };
}
const musicRegistration = registrationTracker("music");
musicRegistration();

// Task 5: Objects & Prototypes
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const artEvent = new Event("Painting Workshop", "2025-07-10", 5);
console.log(Object.entries(artEvent));

// Task 6: Arrays & Methods
const eventTitles = events.map(e => `${e.category.toUpperCase()}: ${e.name}`);
const musicEvents = events.filter(e => e.category === "music");

// Task 7: DOM Manipulation
function showFee(selectElem) {
  const fee = selectElem.value;
  document.getElementById("fee").innerText = `Fee: $${fee}`;
}

function validatePhone() {
  const phone = document.getElementById("phone").value;
  if (!/^\d{10}$/.test(phone)) alert("Enter valid 10-digit number");
}

// Task 8: Event Handling
const searchBox = document.getElementById("searchBox");
if (searchBox) {
  searchBox.addEventListener("keydown", e => {
    if (e.key === "Enter") alert(`Searching for: ${e.target.value}`);
  });
}

// Task 9: Async JS
async function fetchEvents() {
  try {
    document.getElementById("eventsContainer").innerText = "Loading...";
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Fetched events:", data.slice(0, 5));
  } catch (err) {
    console.error("Fetch failed:", err);
  }
}
fetchEvents();

// Task 10: Modern JS Features
function greetUser(name = "Guest") {
  console.log(`Hello, ${name}`);
}

const [firstEvent, ...rest] = events;
const eventClone = [...events];

// Task 11: Forms
function register(e) {
  e.preventDefault();
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const confirmation = document.getElementById("confirmation");
  if (!name || !email) return alert("Missing required fields");
  confirmation.innerText = `Thanks ${name}, registration successful.`;
}

// Task 12: AJAX
function postRegistrationData() {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify({ name: "Test", email: "test@test.com" }),
    headers: { "Content-Type": "application/json" },
  })
    .then(res => res.json())
    .then(data => console.log("Posted:", data))
    .catch(err => console.error("Post failed:", err));
  setTimeout(() => console.log("Simulated delay complete"), 2000);
}

// Task 13: Debugging
function debugForm() {
  console.log("Debug form submit");
  debugger; // Use browser DevTools to inspect here
}

// Task 14: jQuery & Frameworks
$("#registerBtn").click(() => {
  alert("jQuery click registered");
});

$(".eventCard").fadeIn(1000).fadeOut(1000);

// Mention: React/Vue helps with reusability, state management, and component structure.
