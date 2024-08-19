-- Insert initial data into request_status table
INSERT INTO request_status (request_status_id, request_status, request_status_desc, last_updated_date)
VALUES
    (0, 'UNSPECIFIED', 'Unspecified status', now()),
    (1, 'CREATED', 'Request has been created', now()),
    (2, 'PENDING_VOLUNTEER_ASSIGNMENT', 'Pending volunteer assignment', now()),
    (3, 'IN_PROGRESS', 'Request is in progress', now()),
    (4, 'COMPLETED', 'Request has been completed', now()),
    (5, 'CANCELLED', 'Request has been cancelled', now()),
    (6, 'DELETED', 'Request has been deleted', now()),
    (7, 'RATED_BY_REQUESTER', 'Request has been rated by requester', now()),
    (8, 'RATED_BY_VOLUNTEER', 'Request has been rated by volunteer', now())
ON CONFLICT (request_status_id) DO NOTHING;

-- Insert initial data into request_priority table
INSERT INTO request_priority (request_priority_id, request_priority, request_priority_desc, last_updated_date)
VALUES
    (0, 'UNSPECIFIED', 'Unspecified priority', now()),
    (1, 'LOW', 'Low priority', now()),
    (2, 'MEDIUM', 'Medium priority', now()),
    (3, 'HIGH', 'High priority', now()),
    (4, 'CRITICAL', 'Note: we will NOT handle any life threatening use cases', now())
ON CONFLICT (request_priority_id) DO NOTHING;

-- Insert initial data into request_type table
INSERT INTO request_type (request_type_id, request_type, request_type_desc, last_updated_date)
VALUES
    (0, 'UNSPECIFIED', 'Unspecified type', now()),
    (1, 'IN_PERSON', 'In-person request', now()),
    (2, 'REMOTE', 'Remote request', now())
ON CONFLICT (request_type_id) DO NOTHING;

-- Insert initial data into request_category table
INSERT INTO request_category (request_category_id, request_category, request_category_desc, last_updated_date)
VALUES
    (0, 'CLOTHES', 'Clothing-related request', now()),
    (1, 'COLLEGE_ADMISSIONS', 'College admissions-related request', now()),
    (2, 'COOKING', 'Cooking-related request', now()),
    (3, 'EDUCATION', 'Education-related request', now()),
    (4, 'EMPLOYMENT', 'Employment-related request', now()),
    (5, 'FINANCE', 'Finance-related request', now()),
    (6, 'FOOD', 'Food-related request', now()),
    (7, 'GARDENING', 'Gardening-related request', now()),
    (8, 'HOMELESSNESS', 'Homelessness-related request', now()),
    (9, 'HOUSING', 'Housing-related request', now()),
    (10, 'JOBS', 'Jobs-related request', now()),
    (11, 'INVESTING', 'Investing-related request', now()),
    (12, 'MATRIMONIAL', 'Matrimonial-related request', now()),
    (13, 'MEDICAL', 'Medical-related request', now()),
    (14, 'SCHOOL', 'School-related request', now()),
    (15, 'SHOPPING', 'Shopping-related request', now()),
    (16, 'SPORTS', 'Sports-related request', now()),
    (17, 'STOCKS', 'Stocks-related request', now())
ON CONFLICT (request_category_id) DO NOTHING;


-- Insert initial data into request_for table
INSERT INTO request_for (request_for_id, request_for, request_for_desc, last_updated_date)
VALUES
    (0, 'UNSPECIFIED', 'Unspecified request for', now()),
    (1, 'SELF', 'Request for self', now()),
    (2, 'OTHER', 'Request for others', now())
ON CONFLICT (request_for_id) DO NOTHING;

-- Insert initial data into country table
INSERT INTO country (country_id, country_name, phone_country_code, last_update_date)
VALUES
    (0, 'United States', 1, now())
ON CONFLICT (country_id) DO NOTHING;

-- Insert initial data into state table
INSERT INTO state (state_id, country_id, state_name, last_update_date)
VALUES
    (0, 0, 'Texas', now()),
    (1, 0, 'Colorado', now()),
    (2, 0, 'California', now())
ON CONFLICT (state_id) DO NOTHING;

-- Insert initial data into user_status table
INSERT INTO user_status (user_status_id, user_status, user_status_desc, last_update_date)
VALUES
    (0, 'ACTIVE', 'The volunteer is currently engaged and actively participating in volunteering activities', now()),
    (1, 'INACTIVE', 'The volunteer is not currently participating in any volunteering activities', now()),
    (2, 'PENDING', 'The volunteer has expressed interest but has not yet started volunteering or is awaiting assignment', now()),
    (3, 'ON_HOLD', 'The volunteer’s activities are temporarily suspended, possibly due to personal reasons, vacations etc', now())
ON CONFLICT (user_status_id) DO NOTHING;

-- Insert initial data into user_category table
INSERT INTO user_category (user_category_id, user_category, user_category_desc, last_update_date)
VALUES
    (0, 'MEMBER', 'Represents users who are members of the organization.', now()),
    (1, 'DONOR', 'Represents users who contribute financially or materially to the organization.', now()),
    (2, 'VOLUNTEER', 'Represents users who actively participate in volunteering activities.', now())
ON CONFLICT (user_category_id) DO NOTHING;


-- Insert initial data into users table
INSERT INTO users (user_id, state_id, country_id, full_name, primary_email_address, user_status_id, user_category_id, last_update_date)
VALUES
    (0, 1, 0, 'John Doe', 'john.doe@example.com', 0, 2, now()),
    (1, 2, 0, 'Jane Smith', 'jane.smith@example.com', 0, 2, now()),
    (2, 0, 0, 'Alice Johnson', 'alice.johnson@example.com', 0, 2, now()),
    (3, 0, 0, 'Bob Brown', 'bob.brown@example.com', 0, 2, now()),
    (4, 1, 0, 'Charlie Davis', 'charlie.davis@example.com', 0, 2, now()),
    (5, 2, 0, 'Emily White', 'emily.white@example.com', 0, 2, now()),
    (6, 0, 0, 'Frank Black', 'frank.black@example.com', 0, 2, now()),
    (7, 1, 0, 'Grace Lee', 'grace.lee@example.com', 0, 2, now()),
    (8, 2, 0, 'Hannah Green', 'hannah.green@example.com', 0, 2, now()),
    (9, 0, 0, 'Ivy Scott', 'ivy.scott@example.com', 0, 2, now()),
    (10, 1, 0, 'Jack Wilson', 'jack.wilson@example.com', 0, 2, now()),
    (11, 2, 0, 'Kara Young', 'kara.young@example.com', 0, 2, now()),
    (12, 0, 0, 'Liam King', 'liam.king@example.com', 0, 2, now()),
    (13, 1, 0, 'Mia Allen', 'mia.allen@example.com', 0, 2, now())
ON CONFLICT (user_id) DO NOTHING;


-- Insert initial data into volunteers_assigned table assuming 4 users (1,2,3,4)
INSERT INTO volunteers_assigned (
    volunteers_assigned_id, request_id, volunteer_id, volunteer_type, last_update_date
) VALUES
    (0, 'REQ-00-000-000-0001', '1', 'LEAD', now()),
    (1, 'REQ-00-000-000-0001', '2', 'HELPER', now()),
    (2, 'REQ-00-000-000-0001', '3', 'HELPER', now()),
    (3, 'REQ-00-000-000-0002', '2', 'LEAD', now()),
    (4, 'REQ-00-000-000-0002', '0', 'HELPER', now()),
    (5, 'REQ-00-000-000-0002', '1', 'HELPER', now()),
    (6, 'REQ-00-000-000-0002', '3', 'HELPER', now()),
    (7, 'REQ-00-000-000-0003', '2', 'HELPER', now()),
    (8, 'REQ-00-000-000-0003', '0', 'LEAD', now()),
    (9, 'REQ-00-000-000-0004', '0', 'LEAD', now())
ON CONFLICT (volunteers_assigned_id) DO NOTHING;

