#ifndef RANDO_H
#define RANDO_H

#include <random>

class Rando_int {
	std::default_random_engine eng;
	std::uniform_int_distribution<> dist;
public:
	Rando_int(int, int);
	int operator()();
	void seed(int s);
};

#endif
