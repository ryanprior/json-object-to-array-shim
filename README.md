# JSON object-to-array shim

This tool accepts a JSON object on `stdin` and emits a JSON array on `stdout`.
This is useful if you like dealing with arrays and do not like dealing with
objects.

Example session:
```sh-session
$ mvn package
# ...packaging...
$ echo '{"foo": "2", "bar": "3"}' | java -cp ~/.m2/repository/com/eclipsesource/minimal-json/minimal-json/0.9.5/minimal-json-0.9.5.jar:target/json_shim-1.0-SNAPSHOT.jar com.ryanprior.json_shim.App
[
  {
    "name": "foo",
    "value": "2"
  },
  {
    "name": "bar",
    "value": "3"
  }
]
```
