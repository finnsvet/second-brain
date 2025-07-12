#include <iostream>
#include <iomanip>

using namespace std;

class Vector {
  public:
    Vector(int s): elem{ new double[s] }, sz{s} {}
    double& operator[](int s) { return elem[s]; }
    int size() { return sz; }
  private:
    double* elem;
    int sz;
};

double read_and_sum(int s)
{
  Vector vec(s);
  double sum = 0;

  for (int i=0; i!=vec.size(); ++i)
    cin >> vec[i];
  for (int i=0; i!=vec.size(); ++i)
    sum += vec[i];

  return sum;
}

int main()
{
  cout << "How many numbers are you summing?\n";
  double num; cin >> num;
  cout << setprecision(5) << "input them:\n" << read_and_sum(num) << " is the sum\n";
}
