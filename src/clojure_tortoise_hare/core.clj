(ns clojure-tortoise-hare.core)

(defn floyd-mu
  [f tortoise hare mu]
  (if (= tortoise hare)
    mu
    (recur f (f tortoise) (f hare) (inc mu))))

(defn floyd-lam
  [f tortoise hare lam]
  (if (= tortoise hare)
    lam
    (recur f tortoise (f hare) (inc lam))))

(defn floyd
  "Refer to http://en.wikipedia.org/wiki/Cycle_detection"
  ([f x0]
   (let [[tortoise hare] (floyd f (f x0) (f (f x0)))
         mu  (floyd-mu  f x0       hare         0)
         lam (floyd-lam f tortoise (f tortoise) 1)]
     (println "mu=" mu ", lam=" lam)
     [mu lam]))
  ([f tortoise hare]
   (println "tortoise=" tortoise ", hare=" hare)
   (if (= tortoise hare)
     [tortoise hare]
     (recur f (f tortoise) (f (f hare))))))

(defn mod5
  "Ricky's demo: (x*2) mod 5"
  [x]
  (mod (* x 2) 5))
