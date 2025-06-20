# 1
insert into POSTS (USER_ID, BODY)
values (3, 'Test post');

commit;

# 2
update POSTS
set BODY = 'To delete'
where ID = (
    select t.max_id
    from (select max(ID) max_id from POSTS) t
);

commit;

# 3
delete from POSTS
where ID = (
    select t.max_id
    from (select max(ID) max_id from POSTS) t
);

commit;