CREATE TABLE IF NOT EXISTS Task (
    taskId INT(11) PRIMARY KEY AUTO_INCREMENT,
    taskName VARCHAR(255),
    estimatedTime VARCHAR(255),
    scheduledDate VARCHAR(255),
    startTime VARCHAR(255),
    done BIT(1) DEFAULT b'0',
    completionDate VARCHAR(255),
    priority VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS User (
    userId INT(11) PRIMARY KEY,
    sort VARCHAR(10)
);