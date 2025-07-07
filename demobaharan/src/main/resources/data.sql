-- دپارتمان‌ها
INSERT INTO power (id, title, created_at) VALUES (1, 'فناوری اطلاعات', CURRENT_TIMESTAMP);
INSERT INTO power (id, title, created_at) VALUES (2, 'مهندسی برق', CURRENT_TIMESTAMP);

-- افراد
INSERT INTO person (id, first_name, last_name, email, national_code, location, personnel_code, birth_date, last_degree, department_id, created_at)
VALUES (1, 'علی', 'رضایی', 'ali@test.com', '1111111111', 'تهران', 'P001', '1990-01-01', 'کارشناسی ارشد', 1, CURRENT_TIMESTAMP);

INSERT INTO person (id, first_name, last_name, email, national_code, location, personnel_code, birth_date, last_degree, department_id, created_at)
VALUES (2, 'مریم', 'کریمی', 'maryam@test.com', '2222222222', 'شیراز', 'P002', '1995-05-05', 'کارشناسی', 2, CURRENT_TIMESTAMP);

INSERT INTO person (id, first_name, last_name, email, national_code, location, personnel_code, birth_date, last_degree, department_id, created_at)
VALUES (3, 'رضا', 'احمدی', 'reza@test.com', '3333333333', 'اصفهان', 'P003', '1988-09-09', 'دکتری', 1, CURRENT_TIMESTAMP);

-- استاد مرتبط
INSERT INTO teacher (id, teacher_code, pro_major, person_id, created_at)
VALUES (1, 'T001', 'مهندسی نرم افزار', 1, CURRENT_TIMESTAMP);

-- دانشجو مرتبط
INSERT INTO student (id, student_code, pro_major, person_id, created_at)
VALUES (1, 'S001', 'علوم کامپیوتر', 2, CURRENT_TIMESTAMP);

-- کاربر لاگین
INSERT INTO users (id, username, password, person_id, created_at)
VALUES (1, 'ali123', 'pass123', 1, CURRENT_TIMESTAMP);

INSERT INTO users (id, username, password, person_id, created_at)
VALUES (2, 'maryam456', 'pass456', 2, CURRENT_TIMESTAMP);
