-- Switch to the `academic_erp` database
USE academic_erp;

-- Insert dummy data into the `alumni` table
INSERT INTO alumni (first_name, last_name, email, password, contact_no)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'password123', '9876543210'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'password456', '8765432109'),
    ('Robert', 'Brown', 'robert.brown@example.com', 'password789', '7654321098'),
    ('Alice', 'Johnson', 'alice.johnson@example.com', 'password111', '6543210987'),
    ('Michael', 'Davis', 'michael.davis@example.com', 'password222', '5432109876');

-- Insert dummy data into the `alumni_organization` table
INSERT INTO alumni_organization (joining_date, leaving_date, organization_name, position, alumni_id)
VALUES
    ('2021-01-15', '2023-06-30', 'TechCorp', 'Software Engineer', 1),
    ('2020-03-10', '2022-08-15', 'InnovateX', 'Data Analyst', 2),
    ('2019-07-20', '2021-12-31', 'NextGen Solutions', 'Project Manager', 3),
    ('2022-02-01', '2023-05-20', 'AlphaTech', 'UI/UX Designer', 4),
    ('2020-09-15', '2023-11-01', 'GreenSoft', 'QA Engineer', 5);

-- Insert dummy data into the `alumni_education` table
INSERT INTO alumni_education (address, college_name, degree, joining_year, passing_year, alumni_id)
VALUES
    ('123 Main St, Springfield', 'Springfield University', 'BSc Computer Science', 2017, 2021, 1),
    ('456 Elm St, Shelbyville', 'Shelbyville Tech', 'BA Economics', 2016, 2020, 2),
    ('789 Oak St, Capital City', 'Capital City College', 'MBA', 2018, 2020, 3),
    ('321 Pine St, Ogdenville', 'Ogdenville Institute', 'BFA Design', 2019, 2023, 4),
    ('654 Maple St, North Haverbrook', 'North Haverbrook University', 'BSc Information Technology', 2015, 2019, 5);
