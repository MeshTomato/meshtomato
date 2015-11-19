(ns meshtomato.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]))

(deftest dummy (is (= 1 1)))

(enable-console-print!)

(defn -main [& args]
  (cljs.test/run-tests))

(set! *main-cli-fn* -main)
