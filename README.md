# Schema Inference for NoSQL Databases

Master's thesis for Faculty of Mathematics and Physics of the Charles University

## Frozza et al. approach

The Frozza et al. approach implementation is done in Node.js. To be able to run this approach, `node` and `npm` must be
available on PATH.

Use `./gradlew :frozza:start` and `./gradlew :frozza:stop` to start and stop the inference server. The server is
available on localhost:4200.

### Windows

The implementation depends on package `node-gyp` to work. `node-gyp` is notoriously difficult to install on Windows due
to dependency on Windows SDK and build tools. Before running the Frozza et al. approach on Windows, you must install the
`windows-build-tools` package using

```shell
npm install --global --production windows-build-tools --vs2015
```

If this doesn't help,
follow [further `node-gyp` troubleshooting tips here](https://spin.atomicobject.com/2019/03/27/node-gyp-windows/).

