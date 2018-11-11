(defproject lattes-xml "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [

                 [org.clojure/clojure "1.9.0"]

                 [org.clojure/data.xml "0.0.8"]
                 ;[org.clojure/data.xml "0.2.0-alpha5"]
                 [org.clojure/data.zip "0.1.2"]

                 [com.github.kyleburton/clj-xpath "1.4.11"]

                 [tolitius/xml-in "0.1.0"]

                 ;; String manipulation
                 [funcool/cuerdas "2.0.5"]

                 ;; Clojure Utility Belt
                 [com.rpl/specter "1.0.3"]
                 [medley "1.0.0"]

                 [enlive "1.1.6"]
  ])
