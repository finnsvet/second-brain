#include <vector>
#include <iostream>

void print(const std::vector<int>& v)
{
  for (auto val : v)
    std::cout << " " << val;
  std::cout << '\n';
}
