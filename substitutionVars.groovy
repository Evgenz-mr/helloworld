ef call(String text){
    if(text){
        def tmpVariables = text.findAll(~/(\$\{[A-z\-\_\.]*\})/).unique()
        for(x in tmpVariables){
            if(env["${x[6..-2]}"]){
                text = text.replace(x, env["${x[6..-2]}"])
            }
            else{echo "ПРЕДУПРЕЖДЕНИЕ! Переменная ${x} не объявлена"}
        }
    }
    return text
}
