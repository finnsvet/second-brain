#include <string>
#include <vector>
#include <iostream>
#include "rando.h"

int main()
{
	constexpr int max = 9;
	Rando_int rand {0, max};

	std::vector<int> sample(max+1);
	for (int i=0; i!=200; ++i)
		++sample[rand()];

	auto mul_char = [](char x, int num){ std::string sum=""; while(num--)sum+=x; return sum; };

	for(int i=0; i!=sample.size(); ++i)
		std::cout << i << '\t' << mul_char('*', sample[i]) << '\n';
}
