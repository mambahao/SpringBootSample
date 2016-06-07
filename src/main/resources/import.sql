-- Role
insert into roles(id, name) values (0, 'Anonymous')
insert into roles(id, name) values (1, 'User')
insert into roles(id, name) values (2, 'Editor')
insert into roles(id, name) values (3, 'Admin')
insert into roles(id, name) values (4, 'Superman')

-- User
insert into users(id, nickname, mobile, email, first_name, last_name, password, enabled, token_expired) values (0, 'superman', '15309384645', 'superman@krypton.com', 'Clark', 'Kent', '$2a$10$ueyslDvFzOQo4u/nTRtzX..FGwQhVYdbcmT7kyOWQKQIPnlikpyru', true, false)
insert into users(id, nickname, mobile, email, first_name, last_name, password, enabled, token_expired) values (1, 'mamba', '18040115586', 'justin@haoyufeng.com', 'Justin', 'Hao', '$2a$10$ueyslDvFzOQo4u/nTRtzX..FGwQhVYdbcmT7kyOWQKQIPnlikpyru', true, false)

-- User <-> Role
insert into users_roles(user_id, role_id) values (0, 4)
insert into users_roles(user_id, role_id) values (1, 1)
