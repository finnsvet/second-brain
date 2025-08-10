#include "rando.h"

Rando_int::Rando_int(int upper, int lower) : dist{upper, lower} {}
int Rando_int::operator()() { return dist(eng); }
void Rando_int::seed(int s) { eng.seed(s); }
