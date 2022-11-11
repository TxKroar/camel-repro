# Camel Repro
Contains a project to reproduce a camel bug that we encountered

## How to use
1. git clone this Repo
2. run `mvn install` in the directory you cloned it to
3. Open it in your IDE of choice
4. Navigate to `camel.repro.camelrepro.camel.pipeline.Consumer#process` and place a Breakpoint on the `LOGGER.error` line
5. Start `camel.repro.camelrepro.CamelReproApplication` with debugger attached
6. Once the Breakpoint is hit, debug at will
