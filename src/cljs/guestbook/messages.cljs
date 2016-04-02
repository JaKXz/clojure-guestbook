(ns guestbook.messages
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [ajax.core :refer [POST]]))

(defn message-list [messages]
  [:ul
   (for [{:keys [guest message] :as id} messages]
     ^{:key id}
     [:li message " ~" guest ])])
