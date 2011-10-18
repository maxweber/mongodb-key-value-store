(ns mongodb-key-value-store.core
  (:use somnium.congomongo))

(defn get-fn [collection-name]
  (fn [key]
    (when-let [value (:value (fetch-one collection-name :where {:_id key}))]
      (read-string value))))

(defn put-fn [collection-name]
  (fn [key value]
    (update! collection-name
             {:_id key}
             {:_id key
              :value (pr-str value)})))

(defn remove-fn [collection-name]
  (fn [key]
    (destroy! collection-name
              {:_id key})))
