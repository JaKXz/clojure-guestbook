-- :name get-messages :? :*
select * from guestbook

-- :name add-message :! :n
insert into guestbook
(guest, message)
  values (:guest, :message)
