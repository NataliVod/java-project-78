clean:
	make -C app clean

build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

update-deps:
	make -C app update-deps

.PHONY: build