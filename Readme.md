# OOP Enrollment System

**Author**: Manalo, Aryl Ross A.

## Features

### 1. Student Management
*   **Full CRUD Operations**: Register, view, update, and remove students.
*   **Scholar Status**: Track scholarship eligibility for automated tuition benefits.
*   **Academic Tracking**: Monitor enrolled units and program details.

### 2. Course & Catalog Management
*   **Course Coordination**: Manage course IDs, titles, programs, and credit units.
*   **Prerequisite System**: Define and enforce course prerequisites during enrollment.
*   **Catalog View**: Comprehensive listing of all available courses and their details.

### 3. Faculty & Instructor Management
*   **Instructor Profiles**: Maintain records of all teaching staff.
*   **Course Assignments**: Dynamically link instructors to specific courses.

### 4. Organizational Structure
*   **Department Management**: Create and organize academic departments.
*   **Section Management**: Manage class sections with capacity limits.
*   **Institutional Linking**: Connect sections to departments for a structured hierarchy.

### 5. Advanced Enrollment Operations
*   **Automated Enrollment**: Enroll students into sections with automatic unit calculation.
*   **Validation Logic**: Enforces prerequisite checks and section capacity limits (Max: 30 students).
*   **Curriculum Mapping**: Link courses to sections and assign faculty to those courses.

### 6. Financial & Tuition Module
*   **Automatic Scholar Discount**: Automatically applies a 100% discount for students marked as scholars.
*   **Flexible Discounting**: Apply manual discount rates for eligible non-scholar students.
*   **Tuition Calculation**: Real-time fee calculation based on total enrolled units.
*   **Payment Processing**: Track payments, verify full payment status, and monitor remaining balances.

### 7. Institutional Hierarchy View
*   **Relational Visualization**: A specialized dashboard to view the deep relationships between Departments -> Sections -> Courses -> Instructors & Students.

### 8. Architectural Design
*   **Facade Pattern**: Uses the `CampusRegistrar` as a central point of contact for multiple specialized services.
*   **Clean Separation of Concerns**: Decoupled UI logic from service and model layers.
*   **Single-Constructor Models**: Enforces data integrity by requiring all primary fields during object instantiation.
