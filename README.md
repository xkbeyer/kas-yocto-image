# Project
Serve as a playground for building a Linux image with support of Yocto.

# Requirements
- kas  
To simplify the build process `kas` is used. That makes it easier to support different local.conf setups.
`kas` git repo: https://github.com/siemens/kas

# Build
Assuming the kas installation is in the `PATH`. In order to be independent from the host build tools (especially glibc version) I use the kas docker build.
```bash
kas-docker build myproduct.yaml
```
_Remark: You don't have to install kas, you can clone the repo and run it directly from there._

# QEMU

``` bash
run-kas shell mydistro.yaml -c 'runqemu tmp/deploy/images/qemux86-64/xkb-core-qemux86-64.rootfs.qemuboot.conf nographic'
```

# Current state
- qemu based image
- one user
- xkb distro
- hello world example application
