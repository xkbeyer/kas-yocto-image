SUMMARY = "Hello World Application."
DESCRIPTION = "Example application recipe using a simple hello world cmake project. Application is installed in the user home path."
SECTION = "Application"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DEPENDS = "addusers"
inherit cmake
SRC_URI:append = "file://src"
S = "${WORKDIR}"

do_install() {
    install -d -m 0755 ${D}/home/john/application
    install -p -m 0755 ${S}/build/hello-world ${D}/home/john/application
    chown john:develop ${D}/home/john/application
    chown john:develop ${D}/home/john/application/hello-world    
}

FILES:${PN} = "/home/john/application/hello-world "
