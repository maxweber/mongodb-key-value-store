(ns mongodb-key-value-store.test.core
  (:use mongodb-key-value-store.core
        [lazytest.describe
         :only [describe it given do-it using testing]]
        [lazytest.expect :only [expect]]
        [somnium.congomongo :only [mongo!]]))

(mongo! :db :test)

(def collection-name "keyvalue")

(def get-value (get-fn collection-name))

(def put-value (put-fn collection-name))

(def remove-value (remove-fn collection-name))

(describe "MongoDB key value store"
  (given [data {:a 1 :b "value" :c :key :d [1 {:e \a} 3]}
          key (:a data)]
    (do-it "should can put an arbitrary Clojure data structure into a MongoDB collection and get it by key"
      (put-value key data)
      (let [stored-data (get-value key)]
        (expect (= data stored-data))))
    (do-it "should also can remove a value from the store by key"
      (remove-value key)
      (expect (= nil (get-value key))))))
