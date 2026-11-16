CREATE DATABASE IF NOT EXISTS ankit_portfolio;
USE ankit_portfolio;

CREATE TABLE IF NOT EXISTS contacts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- After submitting the portfolio contact form, run:
SELECT * FROM contacts ORDER BY created_at DESC;
