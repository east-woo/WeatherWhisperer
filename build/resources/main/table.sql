-- Table to store user information
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       chat_id INT NOT NULL,
                       CONSTRAINT unique_username UNIQUE (username),
                       CONSTRAINT unique_chat_id UNIQUE (chat_id)
);

-- Table to store user locations
CREATE TABLE user_locations (
                                location_id SERIAL PRIMARY KEY,
                                user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
                                location_name VARCHAR(100) NOT NULL,
                                latitude DECIMAL(9,6) NOT NULL,
                                longitude DECIMAL(9,6) NOT NULL
);

-- Table to store scheduled notifications
CREATE TABLE notifications (
                               notification_id SERIAL PRIMARY KEY,
                               user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
                               location_id INT REFERENCES user_locations(location_id) ON DELETE CASCADE,
                               notification_time TIME NOT NULL
);

-- Table to store weather information
CREATE TABLE weather_data (
                              weather_id SERIAL PRIMARY KEY,
                              location_id INT REFERENCES user_locations(location_id) ON DELETE CASCADE,
                              temperature DECIMAL(5,2) NOT NULL,
                              condition VARCHAR(50) NOT NULL,
                              observation_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);