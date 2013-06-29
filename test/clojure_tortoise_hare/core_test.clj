(ns clojure-tortoise-hare.core-test
  (:use clojure.test
        clojure-tortoise-hare.core))

(deftest a-test
  (testing "MD5"
    (is (= [1 4]
           (floyd mod5 101)))))
