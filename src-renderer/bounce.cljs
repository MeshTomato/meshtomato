(ns meshtomato.renderer.bounce)

(def ipc (js/require "ipc"))

(defn ^:export bounce-this []
  (.send ipc "bounce-dock"))

