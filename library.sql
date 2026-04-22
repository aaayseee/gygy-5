-- DDL

-- Authors
CREATE TABLE Authors (
    AuthorID SERIAL PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    BirthYear INT
);

-- Categories
CREATE TABLE Categories (
    CategoryID SERIAL PRIMARY KEY,
    CategoryName VARCHAR(50) NOT NULL,
    Description VARCHAR(255)
);

-- Shelves
CREATE TABLE Shelves (
    ShelfID SERIAL PRIMARY KEY,
    ShelfCode VARCHAR(20) NOT NULL UNIQUE,
    Floor INT,
    Section VARCHAR(50)
);

-- Departments
CREATE TABLE Departments (
    DeptID SERIAL PRIMARY KEY,
    DeptName VARCHAR(100) NOT NULL,
    Faculty VARCHAR(100)
);

-- Staff
CREATE TABLE Staff (
    StaffID SERIAL PRIMARY KEY,
    BadgeNo VARCHAR(20) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    Role VARCHAR(50),
    HireDate DATE
);

-- Students
CREATE TABLE Students (
    StudentID SERIAL PRIMARY KEY,
    DeptID INT,
    StudentNo VARCHAR(20) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    Phone VARCHAR(20),
    Status VARCHAR(20) DEFAULT 'Active',
    FOREIGN KEY (DeptID) REFERENCES Departments(DeptID)
);

-- Books
CREATE TABLE Books (
    BookID SERIAL PRIMARY KEY,
    AuthorID INT,
    CategoryID INT,
    ShelfID INT,
    ISBN VARCHAR(20) UNIQUE NOT NULL,
    Title VARCHAR(255) NOT NULL,
    PublishYear INT,
    Publisher VARCHAR(100),
    Language VARCHAR(30),
    PageCount INT,
    TotalCopies INT DEFAULT 1,
    AvailableCopies INT DEFAULT 1,
    FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    FOREIGN KEY (ShelfID) REFERENCES Shelves(ShelfID)
);

-- Reservations
CREATE TABLE Reservations (
    ReservationID SERIAL PRIMARY KEY,
    StudentID INT,
    BookID INT,
    RequestDate DATE NOT NULL,
    Status VARCHAR(30) DEFAULT 'Pending',
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

-- Borrows
CREATE TABLE Borrows (
    BorrowID SERIAL PRIMARY KEY,
    StudentID INT,
    BookID INT,
    StaffID INT,
    BorrowDate DATE NOT NULL,
    DueDate DATE NOT NULL,
    ExtensionCount INT DEFAULT 0,
    Status VARCHAR(30) DEFAULT 'Borrowed',
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

-- Returns
CREATE TABLE Returns (
    ReturnID SERIAL PRIMARY KEY,
    BorrowID INT,
    StaffID INT,
    ReturnDate DATE NOT NULL,
    BookCondition VARCHAR(50),
    Note TEXT,
    FOREIGN KEY (BorrowID) REFERENCES Borrows(BorrowID),
    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

-- Fines
CREATE TABLE Fines (
    FineID SERIAL PRIMARY KEY,
    BorrowID INT,
    OverdueDate DATE,
    FineAmount DECIMAL(10, 2) NOT NULL,
    PaymentStatus VARCHAR(30) DEFAULT 'Unpaid',
    PaymentDate DATE,
    FOREIGN KEY (BorrowID) REFERENCES Borrows(BorrowID)
);



-- DML

INSERT INTO Authors (FirstName, LastName, BirthYear) VALUES
('Stefan', 'Zweig', 1881),
('George', 'Orwell', 1903),
('Zülfü', 'Livaneli', 1946),
('Yuval Noah', 'Harari', 1976),
('Sabahattin', 'Ali', 1907);

INSERT INTO Categories (CategoryName, Description) VALUES
('Bilim Kurgu', 'Gelecek, uzay ve teknoloji odaklı kurgular'),
('Tarih', 'Geçmiş olaylar ve analizleri'),
('Psikolojik Roman', 'Karakterlerin iç dünyasını anlatan eserler'),
('Bilgisayar Bilimleri', 'Algoritmalar, yazılım ve mühendislik'),
('Klasikler', 'Tüm zamanların en çok okunan eserleri');

INSERT INTO Shelves (ShelfCode, Floor, Section) VALUES
('A1-BK', 1, 'Kurgu'),
('B2-TR', 2, 'Tarih ve Coğrafya'),
('C1-CS', 3, 'Mühendislik'),
('D4-PS', 1, 'Felsefe & Psikoloji'),
('E2-KL', 2, 'Dünya Klasikleri');

INSERT INTO Departments (DeptName, Faculty) VALUES
('Bilgisayar Mühendisliği', 'Mühendislik Fakültesi'),
('Endüstri Mühendisliği', 'Mühendislik Fakültesi'),
('Tarih', 'Fen Edebiyat Fakültesi'),
('Psikoloji', 'Fen Edebiyat Fakültesi'),
('İşletme', 'İktisadi ve İdari Bilimler Fakültesi');

INSERT INTO Staff (BadgeNo, FirstName, LastName, Email, Role, HireDate) VALUES
('STF-101', 'Ahmet', 'Yılmaz', 'ahmet.y@kutuphane.edu.tr', 'Kütüphaneci', '2020-01-15'),
('STF-102', 'Ayşe', 'Kaya', 'ayse.k@kutuphane.edu.tr', 'Sistem Yöneticisi', '2021-06-01'),
('STF-103', 'Mehmet', 'Demir', 'mehmet.d@kutuphane.edu.tr', 'Kayıt Görevlisi', '2019-11-20'),
('STF-104', 'Zeynep', 'Çelik', 'zeynep.c@kutuphane.edu.tr', 'Kütüphaneci', '2023-02-10'),
('STF-105', 'Burak', 'Şahin', 'burak.s@kutuphane.edu.tr', 'Gece Sorumlusu', '2022-09-05');

INSERT INTO Students (DeptID, StudentNo, FirstName, LastName, Email, Phone, Status) VALUES
(1, '202011001', 'Ali', 'Can', 'ali.can@student.edu.tr', '5551112233', 'Active'),
(2, '202112005', 'Fatma', 'Gül', 'fatma.gul@student.edu.tr', '5552223344', 'Active'),
(1, '201911042', 'Eren', 'Kara', 'eren.kara@student.edu.tr', '5553334455', 'Graduated'),
(4, '202214012', 'Ceren', 'Ak', 'ceren.ak@student.edu.tr', '5554445566', 'Active'),
(3, '202313008', 'Kemal', 'Sarı', 'kemal.sari@student.edu.tr', '5555556677', 'Suspended');

INSERT INTO Books (AuthorID, CategoryID, ShelfID, ISBN, Title, PublishYear, Publisher, Language, PageCount, TotalCopies, AvailableCopies) VALUES
(2, 1, 1, '978-0451524935', '1984', 1949, 'Secker & Warburg', 'English', 328, 5, 3),
(1, 3, 4, '978-6053606116', 'Satranç', 1941, 'İş Bankası Yayınları', 'Turkish', 85, 10, 8),
(4, 2, 2, '978-0062316097', 'Sapiens: Hayvanlardan Tanrılara', 2011, 'Kolektif', 'Turkish', 416, 4, 1),
(5, 5, 5, '978-9750825902', 'Kürk Mantolu Madonna', 1943, 'YKY', 'Turkish', 160, 15, 15),
(3, 3, 1, '978-6050900286', 'Serenad', 2011, 'Doğan Kitap', 'Turkish', 484, 6, 4);

INSERT INTO Reservations (StudentID, BookID, RequestDate, Status) VALUES
(1, 3, '2024-03-01', 'Pending'),
(2, 1, '2024-03-05', 'Fulfilled'),
(4, 5, '2024-03-10', 'Pending'),
(5, 2, '2024-03-12', 'Cancelled'),
(1, 4, '2024-03-15', 'Pending');

INSERT INTO Borrows (StudentID, BookID, StaffID, BorrowDate, DueDate, ExtensionCount, Status) VALUES
(1, 1, 1, '2024-02-01', '2024-02-15', 0, 'Returned'),
(2, 2, 3, '2024-02-10', '2024-02-24', 1, 'Returned'),
(4, 3, 1, '2024-03-01', '2024-03-15', 0, 'Overdue'),
(1, 5, 4, '2024-03-10', '2024-03-24', 0, 'Borrowed'),
(5, 1, 3, '2024-01-05', '2024-01-19', 0, 'Returned');

INSERT INTO Returns (BorrowID, StaffID, ReturnDate, BookCondition, Note) VALUES
(1, 1, '2024-02-14', 'Good', 'Zamanında iade edildi.'),
(2, 3, '2024-02-26', 'Fair', 'Kapakta hafif yıpranma var.'),
(5, 4, '2024-01-25', 'Good', 'Gecikmeli iade.'),
(1, 1, '2024-02-14', 'Good', 'Sorunsuz.'),
(2, 3, '2024-02-28', 'Damaged', 'Sayfalar ıslanmış, ceza uygulandı.');

INSERT INTO Fines (BorrowID, OverdueDate, FineAmount, PaymentStatus, PaymentDate) VALUES
(5, '2024-01-19', 15.50, 'Paid', '2024-01-25'),
(2, '2024-02-24', 50.00, 'Unpaid', NULL),
(3, '2024-03-15', 10.00, 'Unpaid', NULL),
(5, '2024-01-19', 5.00, 'Paid', '2024-01-20'),
(2, '2024-02-24', 25.00, 'Unpaid', NULL);