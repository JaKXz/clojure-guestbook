(ns guestbook.db.core
  (:require
    [conman.core :as conman]
    [mount.core :refer [defstate]]
    [guestbook.config :refer [env]])
  (:import (org.sqlite SQLiteDataSource)))

(defstate ^:dynamic *db*
          :start (conman/connect!
                   {:datasource
                    (doto (SQLiteDataSource.)
                      (.setUrl (env :database-url)))})
          :stop (conman/disconnect! *db*))

(conman/bind-connection *db* "sql/queries.sql")
(mount.core/start #'*db*)
