package dremel.common;

import java.util.LinkedList;
import java.util.List;

import org.apache.avro.Schema;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.IScriptEvaluator;

import dremel.common.JaninoTest.JaninoTestException;



public class AvroExperiments {
	
	
	/**
	 * This script return the value from the int column
	 * @param b
	 * @return
	 * @throws CompileException
	 * @throws Exception
	 */
	public static IScriptEvaluator buildIdentityScriptForIntColumn()
    throws CompileException, Exception {
		IScriptEvaluator se =
        CompilerFactoryFactory.getDefaultCompilerFactory().
        newScriptEvaluator();
		se.setReturnType(Object.class);
		se.setDefaultImports(new String[]{
            "static dremel.common.JaninoTest.JaninoTestReturnObject",
            "static dremel.common.JaninoTest.JaninoTestException"});
		se.setParameters(new String[]{"param"},
        new Class[]{dremel.common.Drec.ScannerFacade.ColumnScanner.class});
		se.setThrownExceptions(new Class[]{JaninoTestException.class});
		se.cook("" + "JaninoTestReturnObject o = new JaninoTestReturnObject();" +
        "return param.curVal;");
return se;
}

	

	public static Schema createUrlOnlySchema()
	{
		// create hard coded schema for the q16  results the schmea is simply array of Urls.
		
		List<Schema.Field> fields  = new LinkedList<Schema.Field>();
		
		// create id field		
		Schema UrlElementSchema = Schema.create(Schema.Type.INT);
		Schema urlFieldSchema = Schema.createArray(UrlElementSchema);
		
		Schema.Field urlField = new Schema.Field("Forward", urlFieldSchema, null, null);
		
		fields.add(urlField);
		
		Schema schema  = Schema.createRecord(fields);
		//String jsonStr = schema.toString();
		//System.out.println(jsonStr);
		return schema;
	}
	
	public static Schema createForwardOnlySchema2()
	{
		// create hard coded schema for the q16  results the schmea is simply array of Urls.
		
		List<Schema.Field> fields  = new LinkedList<Schema.Field>();
		
		// create id field
		Schema UrlElementSchema = Schema.create(Schema.Type.INT);
		Schema urlFieldSchema = Schema.createArray(UrlElementSchema);
		
		Schema.Field urlField = new Schema.Field("Forward2", urlFieldSchema, null, null);
		
		Schema.Field otherField = new Schema.Field("Forward2", urlFieldSchema, null, null);
		
		fields.add(urlField);
		fields.add(otherField);
		Schema schema  = Schema.createRecord(fields);
		String jsonStr = schema.toString();
		System.out.println(jsonStr);
		return schema;
	}
	
	public static void testEquals()
	{
		Schema first = createUrlOnlySchema();
		Schema second = createForwardOnlySchema2();
		boolean equals = first.equals(second);
		if(equals)
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not equals");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	createUrlOnlySchema();
		testEquals();
	}

}
