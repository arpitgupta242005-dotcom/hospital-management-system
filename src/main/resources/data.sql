TRUNCATE TABLE patient_tbl RESTART IDENTITY CASCADE;

INSERT INTO patient_tbl(name, gender, birth_date, email, blood_group)
VALUES
    ('Arpit', 'MALE', '2005-05-24', 'arpit@gmail.com', 'O_positive'),
    ('mansi', 'FEMALE', '2002-08-20', 'mansi@gmail.com', 'B_positive');