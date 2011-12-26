(ns sandbox.core
  (:import org.apache.commons.net.ftp.FTPClient))

(def ^:dynamic *ftp-client*)

(defmacro with-ftp
  "Execute body within the context of an ftp connection"
  [host username password & body]
  `(binding [*ftp-client* (FTPClient.)]
    (doto *ftp-client*
      (.connect ~host)
      (.login ~username ~password))
    (do ~@body)
    (.disconnect *ftp-client*)))

(defn list-files
  "Return a list of filenames from the current directory."
  []
   (map #(.getName %) (.listFiles *ftp-client*)))

(defn retrieve-file
  "Retrieve a file"


(defn file-digest-sha1
  "Return the sha-1 digest of the file"
  [ftp file]
  ())
