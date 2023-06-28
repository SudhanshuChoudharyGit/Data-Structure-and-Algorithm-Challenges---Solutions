class Solution {
public:

    bool isOperator(string st)
    {
        if(st=="+" || st=="-" || st=="*" || st=="/") return true;
        else return false;
    }

    int fun(stack<string>& s)
    {
        string op= s.top();
        int opd1;
        int opd2;
        s.pop();
        if(isOperator(s.top())) opd1=fun(s);
        else
        {
            opd1=stoi(s.top());
            s.pop();
        }
        if(isOperator(s.top())) opd2=fun(s);
        else
        {
            opd2=stoi(s.top());
            s.pop();
        }
        if(op=="+") return opd2+opd1;
        if(op=="*") return opd2*opd1;
        if(op=="/") return opd2/opd1;
        if(op=="-") return opd2-opd1;
        return 0;
    }

    int evalRPN(vector<string>& tokens) {
        if(tokens.size()==1) return stoi(tokens[0]);
        stack<string> s;
        for(string str : tokens)
        {
            s.push(str);
        }
        return fun(s);
    }
};