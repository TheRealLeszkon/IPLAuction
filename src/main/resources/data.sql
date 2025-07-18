-- Insert Teams
INSERT INTO teams (name, balance) VALUES
('Mumbai Indians', 200000000.00),
('Chennai Super Kings', 180000000.00);

-- Insert Batsmen
INSERT INTO batsmen (name, association, price, image_links, status, sold_price, team_id, runs, matches, batting_avg, strike_rate)
VALUES
('Rohit Sharma', 'India', 15000000.00, 'https://ipl-stats-sports-mechanic.s3.ap-south-1.amazonaws.com/ipl/playerimages/Rohit%20Sharma.png', 'FOR_SALE', NULL, NULL, 5876, 200, 32.10, 130.00),
('Ruturaj Gaikwad', 'India', 8000000.00, 'https://ipl-stats-sports-mechanic.s3.ap-south-1.amazonaws.com/ipl/playerimages/Ruturaj%20Gaikwad.png', 'FOR_SALE', NULL, NULL, 1797, 60, 39.50, 136.25);

-- Insert Bowlers
INSERT INTO bowlers (name, association, price, image_links, status, sold_price, team_id, wickets, matches, economy, best_figure)
VALUES
('Jasprit Bumrah', 'India', 12000000.00, 'https://documents.iplt20.com/ipl/IPLHeadshot2025/9.png', 'FOR_SALE', NULL, NULL, 145, 125, 23.50, '5/27'),
('Deepak Chahar', 'India', 6000000.00, 'https://ipl-stats-sports-mechanic.s3.ap-south-1.amazonaws.com/ipl/playerimages/Deepak%20Chahar.png', 'FOR_SALE', NULL, NULL, 59, 63, 29.25, '4/13');

-- Insert All-Rounders
INSERT INTO all_rounders (name, association, price, image_links, status, sold_price, team_id, runs, wickets,economy, matches, strike_rate)
VALUES
('Hardik Pandya', 'India', 17000000.00, 'https://ipl-stats-sports-mechanic.s3.ap-south-1.amazonaws.com/ipl/playerimages/Hardik%20Pandya.png', 'FOR_SALE', NULL, NULL, 1963, 50,23.50, 125, 140.85),
('Moeen Ali', 'England', 9000000.00, 'https://ipl-stats-sports-mechanic.s3.ap-south-1.amazonaws.com/ipl/playerimages/Moeen%20Ali.png', 'FOR_SALE', NULL, NULL, 1033, 33,23.50, 75, 135.50);
