# Project
Serve as a playground for building a linux image with support of Yocto.

# Requirements
- kas
To simplify the build process `kas` is used. That makes it easier to support different local.conf setups.

# Build
Assuming the kas installation is in the `PATH`.
```bash
runkas build myproduct.yaml
```

# QEMU
A shell script `rq.sh` as a template is provided.

``` bash
./rq.sh
```

# Current state
- qemu based image
- one user
- Based on the poky distro.
