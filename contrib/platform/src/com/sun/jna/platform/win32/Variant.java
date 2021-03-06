package com.sun.jna.platform.win32;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.OaIdl.CURRENCY;
import com.sun.jna.platform.win32.OaIdl.DATE;
import com.sun.jna.platform.win32.OaIdl.DATEbyReference;
import com.sun.jna.platform.win32.OaIdl.DECIMAL;
import com.sun.jna.platform.win32.OaIdl.SAFEARRAY;
import com.sun.jna.platform.win32.OaIdl.VARIANT_BOOL;
import com.sun.jna.platform.win32.OaIdl.VARIANT_BOOLbyReference;
import com.sun.jna.platform.win32.OaIdl._VARIANT_BOOLbyReference;
import com.sun.jna.platform.win32.WTypes.BSTR;
import com.sun.jna.platform.win32.WTypes.VARTYPE;
import com.sun.jna.platform.win32.WinDef.BYTE;
import com.sun.jna.platform.win32.WinDef.CHAR;
import com.sun.jna.platform.win32.WinDef.CHARbyReference;
import com.sun.jna.platform.win32.WinDef.LONG;
import com.sun.jna.platform.win32.WinDef.LONGLONG;
import com.sun.jna.platform.win32.WinDef.LONGLONGbyReference;
import com.sun.jna.platform.win32.WinDef.LONGbyReference;
import com.sun.jna.platform.win32.WinDef.PVOID;
import com.sun.jna.platform.win32.WinDef.SCODE;
import com.sun.jna.platform.win32.WinDef.SCODEbyReference;
import com.sun.jna.platform.win32.WinDef.SHORT;
import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinDef.UINTbyReference;
import com.sun.jna.platform.win32.WinDef.ULONG;
import com.sun.jna.platform.win32.WinDef.ULONGLONG;
import com.sun.jna.platform.win32.WinDef.ULONGLONGbyReference;
import com.sun.jna.platform.win32.WinDef.ULONGbyReference;
import com.sun.jna.platform.win32.WinDef.USHORT;
import com.sun.jna.platform.win32.WinDef.USHORTbyReference;
import com.sun.jna.platform.win32.COM.IDispatch;
import com.sun.jna.platform.win32.COM.IRecordInfo;
import com.sun.jna.platform.win32.COM.IUnknown;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;

public interface Variant {

	public static int VT_EMPTY = 0;
	public static int VT_NULL = 1;
	public static int VT_I2 = 2;
	public static int VT_I4 = 3;
	public static int VT_R4 = 4;
	public static int VT_R8 = 5;
	public static int VT_CY = 6;
	public static int VT_DATE = 7;
	public static int VT_BSTR = 8;
	public static int VT_DISPATCH = 9;
	public static int VT_ERROR = 10;
	public static int VT_BOOL = 11;
	public static int VT_VARIANT = 12;
	public static int VT_UNKNOWN = 13;
	public static int VT_DECIMAL = 14;
	public static int VT_I1 = 16;
	public static int VT_UI1 = 17;
	public static int VT_UI2 = 18;
	public static int VT_UI4 = 19;
	public static int VT_I8 = 20;
	public static int VT_UI8 = 21;
	public static int VT_INT = 22;
	public static int VT_UINT = 23;
	public static int VT_VOID = 24;
	public static int VT_HRESULT = 25;
	public static int VT_PTR = 26;
	public static int VT_SAFEARRAY = 27;
	public static int VT_CARRAY = 28;
	public static int VT_USERDEFINED = 29;
	public static int VT_LPSTR = 30;
	public static int VT_LPWSTR = 31;
	public static int VT_RECORD = 36;
	public static int VT_INT_PTR = 37;
	public static int VT_UINT_PTR = 38;
	public static int VT_FILETIME = 64;
	public static int VT_BLOB = 65;
	public static int VT_STREAM = 66;
	public static int VT_STORAGE = 67;
	public static int VT_STREAMED_OBJECT = 68;
	public static int VT_STORED_OBJECT = 69;
	public static int VT_BLOB_OBJECT = 70;
	public static int VT_CF = 71;
	public static int VT_CLSID = 72;
	public static int VT_VERSIONED_STREAM = 73;
	public static int VT_BSTR_BLOB = 0xfff;
	public static int VT_VECTOR = 0x1000;
	public static int VT_ARRAY = 0x2000;
	public static int VT_BYREF = 0x4000;
	public static int VT_RESERVED = 0x8000;
	public static int VT_ILLEGAL = 0xffff;
	public static int VT_ILLEGALMASKED = 0xfff;
	public static int VT_TYPEMASK = 0xfff;

	public static VARIANT_BOOL VARIANT_TRUE = new VARIANT_BOOL(0xFFFF);
	public static VARIANT_BOOL VARIANT_FALSE = new VARIANT_BOOL(0x0000);

	public static class VARIANT extends Union {

		public static class ByReference extends VARIANT implements
				Structure.ByReference {
		}

		public _VARIANT _variant;

		public DECIMAL decVal;

		public VARIANT() {
			this.setType("_variant");
			this.read();
		}

		public VARIANT(Pointer pointer) {
			super(pointer);
			this.setType("_variant");
			this.read();
		}

		public VARIANT(BSTR value) {
			this();
			this.setValue(VT_BSTR, value);
		}

		public VARIANT(VARIANT_BOOL value) {
			this();
			this.setValue(VT_BOOL, value);
		}

		public VARIANT(LONG value) {
			this();
			this.setValue(VT_I4, value);
		}

		public VARIANT(SHORT value) {
			this();
			this.setValue(VT_I2, value);
		}

		public VARTYPE getVarType() {
			this.read();
			return _variant.vt;
		}

		public void setVarType(short vt) {
			this._variant.vt = new VARTYPE(vt);
		}

		public void setValue(int vt, Object value) {
			this.setValue(new VARTYPE(vt), value);
		}

		public void setValue(VARTYPE vt, Object value) {
			switch (vt.intValue()) {
			case VT_I2:
				this._variant.__variant.writeField("iVal", value);
				break;
			case VT_I4:
				this._variant.__variant.writeField("lVal", value);
				break;
			case VT_BSTR:
				this._variant.__variant.writeField("bstrVal", value);
				break;
			case VT_DISPATCH:
				this._variant.__variant.writeField("pdispVal", value);
				break;
			case VT_BOOL:
				this._variant.__variant.writeField("boolVal", value);
				break;
			case VT_SAFEARRAY:
				this._variant.__variant.writeField("parray", value);
				break;
			case VT_ARRAY:
				this._variant.__variant.writeField("parray", value);
				break;
			}

			this._variant.writeField("vt", vt);
			this.write();
		}

		public Object getValue() {
			this.read();
			switch (this.getVarType().intValue()) {
			case VT_I2:
				return this._variant.__variant.readField("iVal");
			case VT_I4:
				return this._variant.__variant.readField("lVal");
			case VT_BSTR:
				return this._variant.__variant.readField("bstrVal");
			case VT_DISPATCH:
				return this._variant.__variant.readField("pdispVal");
			case VT_BOOL:
				return this._variant.__variant.readField("boolVal");
			case VT_SAFEARRAY:
				return this._variant.__variant.readField("parray");
			default:
				return null;
			}
		}

		public static class _VARIANT extends Structure {

			public VARTYPE vt;
			public short wReserved1;
			public short wReserved2;
			public short wReserved3;
			public __VARIANT __variant;

			public _VARIANT() {
			}

			public _VARIANT(Pointer pointer) {
				super(pointer);
				this.read();
			}

			public static class __VARIANT extends Union {
				// LONGLONG VT_I8
				public LONGLONG llVal;
				// LONG VT_I4
				public LONG lVal;
				// BYTE VT_UI1
				public BYTE bVal;
				// SHORT VT_I2
				public SHORT iVal;
				// FLOAT VT_R4
				public Float fltVal;
				// DOUBLE VT_R8
				public Double dblVal;
				// VARIANT_BOOL VT_BOOL
				public VARIANT_BOOL boolVal;
				// SCODE VT_ERROR
				public SCODE scode;
				// CY VT_CY
				public CURRENCY cyVal;
				// DATE VT_DATE
				public DATE date;
				// BSTR VT_BSTR
				public BSTR bstrVal;
				// IUnknown * VT_UNKNOWN
				public IUnknown punkVal;
				// IDispatch * VT_DISPATCH
				public IDispatch pdispVal;
				// SAFEARRAY * VT_ARRAY
				public SAFEARRAY.ByReference parray;
				// BYTE * VT_BYREF|VT_UI1
				public ByteByReference pbVal;
				// SHORT * VT_BYREF|VT_I2
				public ShortByReference piVal;
				// LONG * VT_BYREF|VT_I4
				public LONGbyReference plVal;
				// LONGLONG * VT_BYREF|VT_I8
				public LONGLONGbyReference pllVal;
				// FLOAT * VT_BYREF|VT_R4
				public FloatByReference pfltVal;
				// DOUBLE * VT_BYREF|VT_R8
				public DoubleByReference pdblVal;
				// VARIANT_BOOL * VT_BYREF|VT_BOOL
				public VARIANT_BOOLbyReference pboolVal;
				// VARIANT_BOOL * VT_BYREF|VT_BOOL
				public _VARIANT_BOOLbyReference pbool;
				// SCODE * VT_BYREF|VT_ERROR
				public SCODEbyReference pscode;
				// CY * VT_BYREF|VT_CY
				public CURRENCY.ByReference pcyVal;
				// DATE * VT_BYREF|VT_DATE
				public DATEbyReference pdate;
				// BSTR * VT_BYREF|VT_BSTR
				public BSTR.ByReference pbstrVal;
				// IUnknown ** VT_BYREF|VT_UNKNOWN
				public IUnknown.ByReference ppunkVal;
				// IDispatch ** VT_BYREF|VT_DISPATCH
				public IDispatch.ByReference ppdispVal;
				// SAFEARRAY ** VT_BYREF|VT_ARRAY
				public SAFEARRAY.ByReference pparray;
				// VARIANT * VT_BYREF|VT_VARIANT
				public VARIANT.ByReference pvarVal;
				// PVOID VT_BYREF (Generic ByRef)
				public PVOID byref;
				// CHAR VT_I1
				public CHAR cVal;
				// USHORT VT_UI2
				public USHORT uiVal;
				// ULONG VT_UI4
				public ULONG ulVal;
				// ULONGLONG VT_UI8
				public ULONGLONG ullVal;
				// INT VT_INT
				public Integer intVal;
				// UINT VT_UINT
				public UINT uintVal;
				// DECIMAL * VT_BYREF|VT_DECIMAL
				public DECIMAL.ByReference pdecVal;
				// CHAR * VT_BYREF|VT_I1
				public CHARbyReference pcVal;
				// USHORT * VT_BYREF|VT_UI2
				public USHORTbyReference puiVal;
				// ULONG * VT_BYREF|VT_UI4
				public ULONGbyReference pulVal;
				// ULONGLONG * VT_BYREF|VT_UI8
				public ULONGLONGbyReference pullVal;
				// INT * VT_BYREF|VT_INT
				public IntByReference pintVal;
				// UINT * VT_BYREF|VT_UINT
				public UINTbyReference puintVal;

				public static class BRECORD extends Structure {
					public static class ByReference extends BRECORD implements
							Structure.ByReference {
					}

					public PVOID pvRecord;

					public IRecordInfo pRecInfo;

					public BRECORD() {
					}

					public BRECORD(Pointer pointer) {
						super(pointer);
					}

					@Override
					protected List getFieldOrder() {
						return Arrays.asList(new String[] { "pvRecord",
								"pRecInfo" });
					}
				}

				public __VARIANT() {
					super();
					this.read();
				}

				public __VARIANT(Pointer pointer) {
					super(pointer);
					this.read();
				}
			}

			@Override
			protected List getFieldOrder() {
				return Arrays.asList(new String[] { "vt", "wReserved1",
						"wReserved2", "wReserved3", "__variant" });
			}
		}
	}

	public static class VariantArg extends Structure {

		public static class ByReference extends VariantArg implements
				Structure.ByReference {
		}

		public VARIANT[] variantArg;

		public VariantArg() {
		}

		public VariantArg(VARIANT[] variantArg) {
			this.variantArg = variantArg;
		}

		@Override
		protected List getFieldOrder() {
			return Arrays.asList(new String[] { "variantArg" });
		}
	}
}
