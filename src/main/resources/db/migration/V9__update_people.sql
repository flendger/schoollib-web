alter table people
add column created_at timestamp default current_timestamp, 
add column updated_at timestamp default current_timestamp